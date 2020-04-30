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

class SpaceTraderTheme (context: Context): Theme, ThemeImpl(context) {

    override val id: String = "spacetrader_dark"

    override val resourceLocations = mapOf(
            Pair(ResourceLocation.SharedThemeLocation, "${localFileScheme}Themes/SpaceTrader_dark/spaceTrader_dark-"),
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
        if (family?.toLowerCase() == "nasalization") {
            return when (weight?.toLowerCase()) {
                "regular" -> ResourcesCompat.getFont(context, R.font.nasalization_rg)
                "medium" -> ResourcesCompat.getFont(context, R.font.nasalization_rg)
                "book" -> ResourcesCompat.getFont(context, R.font.nasalization_rg)
                "bold" -> ResourcesCompat.getFont(context, R.font.nasalization_bd)
                "light" -> ResourcesCompat.getFont(context, R.font.nasalization_lt)
                else -> null
            }
        }
        return null
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


