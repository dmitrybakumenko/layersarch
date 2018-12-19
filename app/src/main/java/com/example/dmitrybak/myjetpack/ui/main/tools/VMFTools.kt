package com.example.dmitrybak.myjetpack.ui.main.tools

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.dmitrybak.myjetpack.ui.VMLFBase

class VMFTools(app: Application): VMLFBase<LayerTools>(app){
    val email: String
        get() = layer?.info()?.userEmail ?: ""

    val password: String
        get() = layer?.info()?.userPassword ?: ""
}