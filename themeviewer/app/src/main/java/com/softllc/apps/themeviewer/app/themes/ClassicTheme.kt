package com.greendotcorp.core.theme.app.themes

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.greendotcorp.core.theme.lib.Theme
import com.greendotcorp.core.theme.lib.core.ThemeDrawable
import com.greendotcorp.core.theme.lib.core.ThemeFont
import com.greendotcorp.core.theme.lib.core.ThemeImpl
import com.greendotcorp.core.theme.lib.model.*
import com.softllc.apps.themeviewer.R

class ClassicTheme (context: Context): Theme, ThemeImpl(context) {

    override val id: String? = "classic_light"

    override val resourceLocations = mapOf(
        Pair(
            ResourceLocation.SharedThemeLocation,
            "${sharedFileScheme}Themes/Classic_light/classic_light-"
        ),
        //  Pair(ResourceLocation.SharedThemeLocation,"https://mcnerthney.github.io/common/Themes/Classic_light/classic_light-"),
            Pair(ResourceLocation.SharedDrawableLocation, "${id}__"),
            Pair(ResourceLocation.AndroidDrawableLocation, "${id}__")
    )

    override val globalStyle = loadTheme(ThemeFileName.GlobalStyle, ThemeGlobal::class.java)
    override val account = loadTheme(ThemeFileName.Account,  ThemeAccount::class.java)
    override val challenges = loadTheme(ThemeFileName.Challenges,  ThemeChallenges::class.java)
    override val home = loadTheme(ThemeFileName.Home, ThemeHome::class.java)
    override val moveMoney = loadTheme(ThemeFileName.MoveMoney, ThemeMoveMoney::class.java)
    override val rewards = loadTheme(ThemeFileName.Rewards, ThemeReward::class.java)
    override val tabBar  = loadTheme(ThemeFileName.TabBar, ThemeTabBar::class.java)

    override fun getTypeFaceResource(family: String?, weight: String?): Typeface? {
        var typeface: Typeface? = null
        if (family?.toLowerCase() == "avenirnext") {
            typeface = when (weight?.toLowerCase()) {
                "regular" -> ResourcesCompat.getFont(context, R.font.avenirnext_regular)
                "demibold" -> ResourcesCompat.getFont(context, R.font.avenirnext_demibold)
                "ultralight" -> ResourcesCompat.getFont(context, R.font.avenirnext_ultralight)
                else -> null
            }
        }
        return typeface
    }

    override fun getFont(style: Any?): ThemeFont? {
        return getFontImpl(style)
    }

    override fun getColor(style: Any?): Int? {
        return getColorImpl(style)
    }

    override fun getDrawable(style: Any?): ThemeDrawable? {
        return getThemeDrawableImpl(style)
    }

    override fun getPixelCount(style: Any?): Float? {
        return getThemePixelCountImpl(style)
    }

}


