package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.*

data class ThemeMoveMoney(
        val view : View? = null,
        val header : Header? = null,
        val capabilitiesGrid: Grid? = null,
        val transactors : Transactors? = null,
        val recentActivity : Activity? = null
)