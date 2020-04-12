package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.*

data class ThemeChallenges(

        val view : View? = null,
        val header : Header? = null,

        val sectionHeader : ChallengeTile? = null,
        val accountTile : ChallengeTile? = null,
        val cardTile : ChallengeTile? = null,

        val footer : Footer? = null
)
