package com.greendotcorp.core.theme.app

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greendotcorp.core.theme.app.themes.ClassicTheme
import com.greendotcorp.core.theme.app.themes.SpaceTraderTheme
import com.greendotcorp.core.theme.lib.ThemeManagerEx
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThemeManagerExInit {

    fun loadThemes(context: Context) : LiveData<Boolean> {

        val initialized = MutableLiveData<Boolean>()

        initialized.value = false

        // initialize ThemeManager on main thread to support it's observeForever
        //ThemeManager.changeTheme()

        val oldCurrentId = ThemeManagerEx.current.value?.id
        val ioScope = CoroutineScope(Dispatchers.IO)
        ioScope.launch {

            // load the installed themes
            ThemeManagerEx.setThemes(ClassicTheme(context))
            ThemeManagerEx.setThemes(SpaceTraderTheme(context))

            // set the current theme from saved SharedPreferences
            //ThemeManager.changeTheme()

            val currentId = ThemeManagerEx.current.value?.id
            if ( oldCurrentId == currentId ) {
                ThemeManagerEx.setCurrentTheme(currentId)
            }
            initialized.postValue(true)
        }

        return initialized
    }
}

fun nextTheme(context: Context) {
    val theme = ThemeManagerEx.current.value
    var themeIndex = ThemeManagerEx.themes.value?.indexOfFirst { it.id == theme?.id } ?: 0
    ThemeManagerEx.themes.value?.let { themes ->
        val nextIndex = themeIndex + 1
        if (nextIndex < themes.size) {
            themeIndex = nextIndex
        } else {
            ThemeManagerExInit().loadThemes(context)
            themeIndex = 0
        }
        ThemeManagerEx.setCurrentTheme(themes[themeIndex].id)
    }
}
