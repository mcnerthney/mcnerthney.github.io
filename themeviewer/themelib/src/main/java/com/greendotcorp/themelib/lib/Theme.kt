package com.greendotcorp.core.theme.lib

import com.greendotcorp.core.theme.lib.core.ThemeDrawable
import com.greendotcorp.core.theme.lib.core.ThemeFont
import com.greendotcorp.core.theme.lib.model.*

interface Theme {
    /**
     * id of the theme
     */
    val id: String

    /**
     * Convert the style into a typeface and a text size
     * @param style theme's style element, for example theme.globalStyle.font.regularText
     * @return [ThemeFont] typeface and size of the style
     */
    fun getFont(style: Any?): ThemeFont?

    /**
     * Converts the style into a Color.
     * @param style theme's style element, for example theme.globalStyle.color.primary or theme.tabBar.view.background
     * @return the color in ARGB
     */
    fun getColor(style: Any?) : Int?

    /**
     * Convert the style into a drawable or a file name of an animation.
     *
     * @param style theme's style element, for example theme.account.view.header
     * @return a vector drawable in [ThemeDrawable.drawable] or a string in [ThemeDrawable.animation] for animation files
     */
    fun getDrawable(style: Any?) : ThemeDrawable?

    /**
     * Convert the theme points into rendering pixels
     * @return [Float] dimension converted into screen pixels
     */
    fun getPixelCount(style: Any?) : Float?


    fun getFloat(style: Any?) : Float?  {
        when ( style ) {
            is Float ->  return style
            is Int -> return style.toFloat()
            is Double -> return style.toFloat()
        }
        return null
    }

    /**
     * start of theme elements
     */
    val globalStyle: ThemeGlobal?
    val tabBar: ThemeTabBar?
    val home: ThemeHome?
    val account: ThemeAccount?
    val challenges: ThemeChallenges?
    val moveMoney: ThemeMoveMoney?
    val rewards: ThemeReward?
    /**
     * finish of theme elements
     */




}


