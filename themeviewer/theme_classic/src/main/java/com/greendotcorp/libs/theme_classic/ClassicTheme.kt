package com.softllc.libs.theme_classic

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.greendotcorp.core.theme.model.ThemeGlobal
import com.softllc.libs.core.Theme
import com.softllc.libs.core.ThemeImpl

class ClassicTheme (context: Context): Theme, ThemeImpl(context) {
    override val id: String? = "com.greendot.theme.classic"
    override val name:  String = context.getString(R.string.classic_theme_name)
    override val global: ThemeGlobal? = readGlobalThemeFile("Classic_light/classic_light-globalStyle.json")
    override fun getGlobalTypeface(name: String): Typeface {
        val font =
            when (name.toLowerCase()) {
                "avenirnext_regular" -> ResourcesCompat.getFont(context, R.font.avenir_regular)
                "avenirnext_demibold" -> ResourcesCompat.getFont(context, R.font.avenir_bold)
                "avenirnext_ultralight" -> ResourcesCompat.getFont(context, R.font.avenir_ultra_light)
                else -> return Typeface.DEFAULT
            }

        if (font == null) return Typeface.DEFAULT
        return font
    }

}


