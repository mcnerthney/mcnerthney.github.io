package com.greendotcorp.core.theme.app

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greendotcorp.core.theme.app.themes.ClassicTheme
import com.greendotcorp.core.theme.app.themes.SpaceTraderTheme
import com.greendotcorp.core.theme.lib.ThemeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThemeManagerExInit {

    fun loadThemes(context: Context) : LiveData<Boolean> {

        val initialized = MutableLiveData<Boolean>()

        initialized.value = false

        // initialize ThemeManager on main thread to support it's observeForever
        //ThemeManager.changeTheme()

        val oldCurrentId = ThemeProvider.current.value?.id
        val ioScope = CoroutineScope(Dispatchers.IO)
        ioScope.launch {

            // load the installed themes
            ThemeProvider.setThemes(ClassicTheme(context))
            ThemeProvider.setThemes(SpaceTraderTheme(context))

            // set the current theme from saved SharedPreferences
            //ThemeManager.changeTheme()

            val currentId = ThemeProvider.current.value?.id
            if ( oldCurrentId == currentId ) {
                ThemeProvider.setCurrentTheme(currentId)
            }
            initialized.postValue(true)
        }

        return initialized
    }
}

fun nextTheme(context: Context) {
    val theme = ThemeProvider.current.value
    var themeIndex = ThemeProvider.themes.value?.indexOfFirst { it.id == theme?.id } ?: 0
    ThemeProvider.themes.value?.let { themes ->
        val nextIndex = themeIndex + 1
        if (nextIndex < themes.size) {
            themeIndex = nextIndex
        } else {
            themeIndex = 0
        }
        ThemeProvider.setCurrentTheme(themes[themeIndex].id)
    }
}
