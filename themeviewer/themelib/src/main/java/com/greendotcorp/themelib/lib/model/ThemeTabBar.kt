package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.Tabs

data class ThemeTabBar(
        val tabs: MutableList<Tabs>? = null,
        val xScaleRatio: Double? = null,
        val yScaleRatio: Double? = null,
        val widthByHeightRatio: Double? = null,
        val coverBackground: String? = null,
        val background: String? = null
)