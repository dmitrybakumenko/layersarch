package com.example.dmitrybak.myjetpack.ui.main.tools

import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.LayerBase

class LayerTools(info: LayerInfo = Info("", "")) : LayerBase(info) {
    fun info() = info as Info

    class Info(val userEmail: String, val userPassword: String) : LayerBase.LayerInfo(ELayerType.Tools)
}