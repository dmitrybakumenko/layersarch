package com.example.dmitrybak.myjetpack.ui.main.main

import android.app.Application
import com.example.dmitrybak.myjetpack.ui.VMLFBase

class VMFMain(app: Application) : VMLFBase<LayerMain>(app){
    fun onClickLogout() = layer?.logout()
    fun onClickTools() = layer?.openTools()
}