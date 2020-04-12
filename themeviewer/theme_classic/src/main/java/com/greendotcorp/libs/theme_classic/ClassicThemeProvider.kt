package com.softllc.libs.theme_classic

import com.softllc.libs.core.ApplicationProvider
import com.softllc.libs.core.EmptyProvider
import com.softllc.libs.core.ThemeManagerEx
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassicThemeProvider : EmptyProvider() {

    val ioScope =
        CoroutineScope(Dispatchers.IO)

    override fun onCreate(): Boolean {
        ApplicationProvider.listen { application ->
            ioScope.launch {
                ThemeManagerEx.addTheme(
                    ClassicTheme(application)
                )
            }
        }
        return true
    }

}