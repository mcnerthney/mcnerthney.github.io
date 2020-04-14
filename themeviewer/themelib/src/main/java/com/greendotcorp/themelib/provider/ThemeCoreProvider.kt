package com.greendotcorp.themelib.provider


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThemeCoreProvider : EmptyProvider() {

    val ioScope = CoroutineScope(Dispatchers.IO)


    override fun onCreate(): Boolean {


        ApplicationProvider.listen { application ->
            ioScope.launch {


            }
        }
        return true
    }

}