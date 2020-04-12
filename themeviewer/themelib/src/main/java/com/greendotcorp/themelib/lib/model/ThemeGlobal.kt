package com.greendotcorp.core.theme.lib.model

import com.google.gson.annotations.SerializedName
import com.greendotcorp.core.theme.lib.model.base.*

class ThemeGlobal {
        @SerializedName("colors")
        val color : Colors? = null
        @SerializedName("fonts")
        val font : Fonts? = null
        @SerializedName("dimens")
        val dimen : Dimens? = null
        @SerializedName("composites")
        val composite : Composites? = null
}