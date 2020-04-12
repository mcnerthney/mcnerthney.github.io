package com.greendotcorp.core.theme.lib.core

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.util.Log
import com.google.gson.*
import com.google.gson.internal.LinkedTreeMap
import com.google.gson.stream.JsonReader
import com.greendotcorp.core.theme.lib.Theme
import com.greendotcorp.core.theme.lib.model.base.Colors
import com.greendotcorp.core.theme.lib.model.base.Fonts
import com.greendotcorp.core.theme.lib.model.base.GlobalFont
import java.io.InputStreamReader
import java.net.URI
import java.util.regex.Pattern
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

class ThemeFont(val typeface: Typeface, val size: Float)
class ThemeDrawable(val drawable: Drawable? = null, val animation: String? = null)

abstract class ThemeImpl(val context: Context) {

    protected enum class ThemeFileName(val file: String) {
        GlobalStyle("globalStyle"),
        Account("account"),
        Challenges("challenges"),
        Home("home"),
        MoveMoney("moveMoney"),
        Rewards("rewards"),
        TabBar("tabBar")
    }

    private val LOG_TAG = "ThemeImpl"
    val localFileScheme = "file:///android_asset/"

    protected fun <T : Any> Theme.loadTheme(
        themeFileName: ThemeFileName,
        responseClass: Class<T>
    ): T? {
        val commonName =
            resourceLocations[ResourceLocation.SharedThemeLocation] + themeFileName.file + ".json"

        try {

            val inputStream =
                if (commonName.startsWith(localFileScheme)) {
                    context.assets.open(commonName.removePrefix(localFileScheme))
                }
                else {
                    URI(commonName).toURL().openStream()
                }

            val reader = JsonReader(InputStreamReader(inputStream))
            return gson.fromJson(reader, responseClass)

        } catch (ex: Exception) {
            LogFailed("read ${commonName} ${ex}")
        }
        return null
    }


    protected fun Theme.getFontImpl(font: Any?): ThemeFont? {
        var returnFont: ThemeFont? = null
        if (font is GlobalFont) {
            val typeface = getTypeFaceResource(font.family.toString(), font.weight.toString())
            val textSize = font.size?.toFloat()
            if (typeface != null && textSize != null) {
                returnFont = ThemeFont(
                    typeface,
                    textSize
                )
            }
        }

        val fontTag = "@${ThemeReferenceType.FONT}."

        when (val themeFont = font) {
            is String -> {
                // format: @Font.name
                if (fontTag.startsWith(fontTag, true)) {
                    val value = getGlobalValue(themeFont)
                    if (value is GlobalFont) {
                        val typeface =
                            getTypeFaceResource(value.family.toString(), value.weight.toString())
                        val textSize = value.size?.toFloat()
                        if (typeface != null && textSize != null) {
                            returnFont =
                                ThemeFont(
                                    typeface,
                                    textSize
                                )
                        }
                    }
                }
            }
            is LinkedTreeMap<*, *> -> {
                // format: {"family":"fontname","weight":"bold","size",12}
                val family = themeFont["family"]
                val weight = themeFont["weight"]
                val textSize = themeFont["size"]
                if (family is String && weight is String && textSize is Int) {
                    val typeface = getTypeFaceResource(family, weight)
                    typeface?.let {
                        returnFont =
                            ThemeFont(
                                typeface,
                                textSize.toFloat()
                            )
                    }

                }

            }
        }
        if (returnFont == null) {
            LogFailed("Theme.getFontImpl(${font})")
        }
        return returnFont
    }


    protected fun Theme.getThemeRatioImpl(style: Any?): Float? {
        if (style is Float) {
            return style
        }
        LogFailed("Theme.getThemeRatioImpl(${style})")
        return null
    }

    protected fun Theme.getColorImpl(style: Any?): Int? {
        val colorTag = "@${ThemeReferenceType.COLOR}."

        var colorString = ""
        if (style is String) {
            colorString = style
        }

        var returnColor: Int? = null
        when (val themeColor = colorString) {
            is String -> {
                if (themeColor.startsWith(colorTag, true)) {

                    // format : @Color.primary
                    val value = getGlobalValue(colorString)
                    if (value is String) {
                        returnColor = parseColor(value)
                    }
                } else {
                    // format: #000000AA
                    returnColor = parseColor(themeColor)
                }
            }
        }
        if (returnColor == null) {
            LogFailed("Theme.getColorImpl(${style})")
        }
        return returnColor
    }

    protected fun Theme.getThemeDrawableImpl(style: Any?): ThemeDrawable? {
        var returnThemeDrawable: ThemeDrawable? = null
        when (style) {
            is String -> returnThemeDrawable = findDrawableResource(style)
        }
        if (returnThemeDrawable == null) {
            LogFailed("Theme.getThemeDrawableImpl(${style})")
        }
        return returnThemeDrawable
    }

    protected fun Theme.getThemePixelCountImpl(style: Any?): Float? {
        var returnPixelCount: Float? = null
        if (style is Double) {
            returnPixelCount = convertDpToPixel(style.toFloat())
        }
        if (returnPixelCount == null) {
            LogFailed("Theme.getThemePixelCountImpl(${style})")
        }
        return returnPixelCount
    }

    protected enum class ResourceLocation {
        SharedThemeLocation,
        SharedDrawableLocation,
        AndroidDrawableLocation
    }

    protected abstract val resourceLocations: Map<ResourceLocation, String>

    protected abstract fun getTypeFaceResource(family: String?, weight: String?): Typeface?

    private val DRAWABLE_PDF_SUFFIX = ".pdf"

    private enum class ThemeReferenceType {
        COLOR,
        FONT
    }


    /**
     * Store the theme's global Colors in a HashMap for quick lookups
     */
    private val globalColorSet = HashMap<String, KProperty1<out Colors, *>>()

    private fun Theme.getGlobalColorSet(): HashMap<String, KProperty1<out Colors, *>> {
        if (globalColorSet.isEmpty()) {
            val globalColors = globalStyle?.color
            globalColors?.let {
                val colorFields = it::class.memberProperties
                colorFields.forEach {
                    globalColorSet.set(it.name, it)
                }
            }
        }
        return globalColorSet
    }

    /**
     * Store the theme's global Fonts in a HashMap for quick lookups
     */
    private val globalFontSet = HashMap<String, KProperty1<out Fonts, *>>()

    private fun Theme.getGlobalFontSet(): HashMap<String, KProperty1<out Fonts, *>> {
        if (globalFontSet.isEmpty()) {
            val globalFonts = globalStyle?.font
            globalFonts?.let {
                val fontFields = it::class.memberProperties
                fontFields.forEach {
                    globalFontSet.set(it.name, it)
                }
            }
        }
        return globalFontSet
    }

    private fun Theme.getGlobalValue(reference: Any?): Any? {
        try {
            val GlobalPrefix = "@"
            if (reference is String) {
                if (reference.startsWith(GlobalPrefix)) {
                    val fieldName = reference.removePrefix(GlobalPrefix)
                    val splitName = fieldName.split('.')
                    val typeOfRef = splitName[0]
                    val valueType = splitName[1]

                    globalStyle?.let { _themeGlobal ->
                        when (typeOfRef.toUpperCase()) {
                            ThemeReferenceType.COLOR.name -> _themeGlobal.color?.let { _colors ->
                                val globalColors = getGlobalColorSet()
                                val colorField = globalColors[valueType]
                                colorField?.let {
                                    val field = it as KProperty1<Any, *>
                                    return field.get(_colors)
                                }
                            }
                            ThemeReferenceType.FONT.name -> _themeGlobal.font?.let { _fonts ->
                                val globalFonts = getGlobalFontSet()
                                val fontField = globalFonts[valueType]
                                fontField?.let {
                                    val field = it as KProperty1<Any, *>
                                    return field.get(_fonts)
                                }
                            }
                            else -> {
                            }
                        }
                    }
                }
            }

        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return null
    }


    private fun convertDpToPixel(dp: Float): Float? {
        return dp * context.resources.displayMetrics.density
    }


    private fun String.camelCaseToUnderscore(): String {
        val matcher = Pattern.compile("(?<=[a-z])[A-Z]").matcher(this)
        val sb = StringBuffer()
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group().toLowerCase())
        }
        matcher.appendTail(sb)
        return sb.toString()

    }

    private val assetFileList: HashSet<String>

    init {
        val assetList = context.resources.assets.list("")
        assetFileList = HashSet(assetList?.size ?: 0)
        assetList?.let {
            assetFileList.addAll(assetList)
        }
    }

    private fun findDrawableResource(resourceName: String): ThemeDrawable? {


        if (resourceName.endsWith(DRAWABLE_PDF_SUFFIX, true)) {

            //
            // Convert the Theme PDF resource name into an Android resource identifier
            //
            // For example, convert ResourceName.PDF to /res/theme_name__resource_name
            //

            val imageName =
                resourceLocations[ResourceLocation.AndroidDrawableLocation] + resourceName.removeSuffix(
                    DRAWABLE_PDF_SUFFIX
                ).camelCaseToUnderscore()
            val resourceId =
                context.resources.getIdentifier(imageName, "drawable", context.packageName)

            if (resourceId != 0) return ThemeDrawable(
                context.resources.getDrawable(
                    resourceId,
                    null
                )
            )
            return null


        } else {

            val animationResource =
                resourceLocations[ResourceLocation.SharedDrawableLocation] + resourceName.camelCaseToUnderscore()

            // look for drawable resource in the assets/theme__resource_name
            if (assetFileList.contains(animationResource)) {
                return ThemeDrawable(
                    animation = animationResource
                )
            }

            return null

        }

    }

    private fun parseColor(name: String): Int? {
        try {
            return swapAlpha(name)  // #rrggbbAA to #AArrggbb
        } catch (e: Exception) {
        }
        return null
    }


    private fun swapAlpha(color: String): Int {
        if (color.indexOf("#") == 0 && color.length == 9) {
            val hexValue = color.substring(1).swapSubstrings(7)
            return Color.parseColor("#$hexValue")
        } else {
            return Color.parseColor(color)
        }
    }

    private fun String.swapSubstrings(index: Int): String {
        return substring(index - 1, length) + substring(0, index - 1)
    }

    fun Theme.LogFailed(message: String) {
        Log.w(LOG_TAG, "${id} ${message} returns null")
    }


    private var gson = GsonBuilder().create()


}


