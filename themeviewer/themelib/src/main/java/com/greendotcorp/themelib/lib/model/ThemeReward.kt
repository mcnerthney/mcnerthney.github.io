package com.greendotcorp.core.theme.lib.model

import com.greendotcorp.core.theme.lib.model.base.Header
import com.greendotcorp.core.theme.lib.model.base.RewardsTable
import com.greendotcorp.core.theme.lib.model.base.SearchBar
import com.greendotcorp.core.theme.lib.model.base.SearchTable
import com.greendotcorp.core.theme.lib.model.base.View

data class ThemeReward (
        val view : View? = null,
        val header : Header? = null,
        val searchBar : SearchBar? = null,
        val rewardsTable : RewardsTable? = null,
        val searchTable : SearchTable? = null
)