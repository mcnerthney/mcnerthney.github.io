package com.softllc.apps.themeviewer

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.greendotcorp.core.theme.app.ThemeManagerExInit
import com.greendotcorp.themelib.provider.ThemeCoreProvider


class ThemeViewerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        _initialized.value = false
        ThemeManagerExInit().loadThemes(this)

    }

    private val _initialized = MutableLiveData<Boolean>()
    val initialized: LiveData<Boolean> = _initialized


}
