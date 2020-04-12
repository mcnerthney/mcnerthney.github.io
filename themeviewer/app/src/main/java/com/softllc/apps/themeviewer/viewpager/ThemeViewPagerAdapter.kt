package com.softllc.apps.themeviewer.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.softllc.apps.themeviewer.globalstyle.ThemeChallengesFragment
import com.softllc.apps.themeviewer.globalstyle.ThemeGlobalStyleFragment
import com.softllc.apps.themeviewer.globalstyle.ThemeHomeFragment

enum class ThemeScreenType {
    Challenges,
    GlobalStyle,
//    account,
    Home,


//    moveMoney,
//    rewards,
//    tabBar,

}


class ThemeViewPagerAdapter( fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    var themeGlobalStyleFragment: ThemeGlobalStyleFragment? = null

    override fun getItem(position: Int): Fragment {
        return when (ThemeScreenType.values()[position]) {
            ThemeScreenType.GlobalStyle -> {
                return ThemeGlobalStyleFragment()
            }
            ThemeScreenType.Challenges -> {
                return ThemeChallengesFragment()
            }
            ThemeScreenType.Home -> {
                return ThemeHomeFragment()
            }
            else -> return ThemeViewFragment()//ThemeType.values()[position].name)
        }
    }
    override fun getCount(): Int {
        return ThemeScreenType.values().size
    }



}

