package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.*

data class ThemeAccount(
        val view : View? = null,
        val header : Header? = null,
        val tile : Tile? = null,
        val table : Table? = null,
        val footer : Footer? = null
)