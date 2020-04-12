package com.greendotcorp.core.theme.lib.model.base

data class Colors (

        val primary : String? = null,
        val primaryDark : String? = null,
        val secondary : String? = null,
        val tertiary : String? = null,
        val success : String? = null,
        val warning : String? = null,
        val error : String? = null,

        ////to be removed
//        val alpha1 : String? = null,//to be removed
//        val alpha2 : String? = null,//to be removed
//        val alpha3 : String? = null,//to be removed
//        val alpha4 : String? = null,//to be removed
//        val alpha5 : String? = null,//to be removed

        val adaptive : String? = null,
        val adaptive2 : String? = null,
        val adaptive3 : String? = null,
        val adaptive4 : String? = null,
        val adaptive5 : String? = null,

        val white : String? = null,
        val black : String? = null,

        val viewBackground : String? = null,
        val contentBackground : String? = null,
        val buttonGroupBackground : String? = null,
        val alertModalBackground : String? = null
)

data class Fonts (
        val mainTitle : GlobalFont? = null,
        val subTitle : GlobalFont? = null,
        val subTitleEmphasis : GlobalFont? = null,
        val largeTitle : GlobalFont? = null,
        val smallTitle : GlobalFont? = null,
        val regularText : GlobalFont? = null,
        val regularTextEmphasis : GlobalFont? = null,
        val mediumText : GlobalFont? = null,
        val mediumTextEmphasis : GlobalFont? = null,
        val smallText : GlobalFont? = null,
        val smallTextEmphasis : GlobalFont? = null,
        val xSmallText : GlobalFont? = null,
        val largeNumeral : GlobalFont? = null,
        val largerNumeral : GlobalFont? = null
)

data class GlobalFont (
        val family : String? = null, 
        val size : Double? = null,
        val weight : String? = null
)

data class Composites (
        val tileTitle : Composite? = null,
        val pageTitle : Composite? = null,
        val topNavigationButtonTitle : Composite? = null
)

data class Dimens (
        val xSmallMargin : Double? = null,
        val smallMargin : Double? = null,
        val mediumMargin : Double? = null,
        val largeMargin : Double? = null,
        val xLargeMargin : Double? = null,
        val tileAspectRatio : Double? = null,
        val tileCornerRadius : Double? = null,
        val shadeViewAlpha : Double? = null,
        val shortTransitionAnimationDuration : Double? = null,
        val mediumTransitionAnimationDuration : Double? = null,
        val longTransitionAnimationDuration : Double? = null
)