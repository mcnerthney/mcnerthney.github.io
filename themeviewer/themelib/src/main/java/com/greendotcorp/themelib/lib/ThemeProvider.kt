package com.greendotcorp.core.theme.lib

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *
 */
object ThemeProvider  {

    private val _current = MutableLiveData<Theme?>()
    val current : LiveData<Theme?> = _current

    private val _themes = MutableLiveData<List<Theme>?>()
    val themes : LiveData<List<Theme>?> = _themes

    private val loadedThemes = HashMap<String?, Theme>()

    fun setThemes(newTheme: Theme) {
        synchronized(this) {
            loadedThemes[newTheme.id] = newTheme
            _themes.postValue(
                loadedThemes.values.toList().sortedBy { it.id })
        }
    }

    fun setCurrentTheme(id: String?) {
        synchronized(this) {
            val theme = loadedThemes[id]
            _current.postValue(theme)
        }
    }

}

