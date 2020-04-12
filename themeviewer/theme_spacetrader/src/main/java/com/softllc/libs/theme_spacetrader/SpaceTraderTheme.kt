package com.softllc.libs.theme_spacetrader

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.greendotcorp.core.theme.model.ThemeGlobal
import com.softllc.libs.core.Theme
import com.softllc.libs.core.ThemeImpl

class SpaceTraderTheme (context: Context): Theme, ThemeImpl(context) {

    override val id: String? = "com.greendot.theme.spacetrader"

    var loadedGlobal : ThemeGlobal? = readGlobalThemeFile("SpaceTrader_dark/spaceTrader_dark-globalStyle.json")

    override val global: ThemeGlobal?
       get() = loadedGlobal

    override val name:  String = context.getString(R.string.space_trader_theme_name)


    override fun getGlobalTypeface(name: String): Typeface {
        val font =
            when (name.toLowerCase()) {
                "nasalization_regular" -> ResourcesCompat.getFont(
                    context,
                    R.font.nasalization_regular
                )
                "nasalization_medium" -> ResourcesCompat.getFont(
                    context,
                    R.font.nasalization_regular
                )
                "nasalization_bold" -> ResourcesCompat.getFont(
                    context,
                    R.font.nasalization_bold
                )
                "nasalization_light" -> ResourcesCompat.getFont(
                    context,
                    R.font.nasalization_light
                )
                else -> Typeface.DEFAULT
            }

        if (font == null) return Typeface.DEFAULT
        return font
    }

    //override fun getGlobalColor(color: String?): Int {
    //    return readColor(color)
    //}

}