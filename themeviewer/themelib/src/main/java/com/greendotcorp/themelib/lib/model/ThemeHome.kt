package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.*

data class ThemeHome(
        val view: View? = null,
        val header: Header? = null,
        val cardStatusButton: Button? = null,
        val tile: Tile? = null,
        val recentTransactions: Transaction? = null,
        val capabilitiesGrid: Grid? = null,
        val footer: Footer? = null
)