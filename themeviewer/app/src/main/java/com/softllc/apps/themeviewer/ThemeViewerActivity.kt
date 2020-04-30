package com.softllc.apps.themeviewer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.Observer
import com.greendotcorp.core.theme.lib.ThemeProvider
import com.softllc.apps.themeviewer.databinding.ActivityThemeViewerBinding


class ThemeViewerActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            val binding =  setContentView<ActivityThemeViewerBinding>(this, R.layout.activity_theme_viewer)
            ThemeProvider.current.observe(this, Observer { theme->
                binding.theme = theme
            })

            ThemeProvider.themes.observe(this, Observer { themes ->
                if ( ThemeProvider.current.value == null ) ThemeProvider.setCurrentTheme(themes?.last()?.id)
            })

        }
    }




