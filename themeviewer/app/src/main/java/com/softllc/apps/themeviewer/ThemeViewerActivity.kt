package com.softllc.apps.themeviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import com.greendotcorp.core.theme.lib.ThemeManagerEx
import com.softllc.apps.themeviewer.databinding.ActivityThemeViewerBinding


class ThemeViewerActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val binding =  setContentView<ActivityThemeViewerBinding>(this, R.layout.activity_theme_viewer)
            ThemeManagerEx.current.observe(this, Observer { theme->
                binding.theme = theme
            })

            ThemeManagerEx.themes.observe(this, Observer { themes ->
                if ( ThemeManagerEx.current.value == null ) ThemeManagerEx.setCurrentTheme(themes.last().id)
            })

        }
    }




