package com.example.dmitrybak.myjetpack.ui.main.main

import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.LayerBase
import com.example.dmitrybak.myjetpack.quick_solution.ServiceAuth
import com.example.dmitrybak.myjetpack.ui.main.tools.LayerTools

class LayerMain(val auth: ServiceAuth, info: LayerInfo = LayerMain.Info()) : LayerBase(info) {
    override fun hardBack() = true

    fun logout() = auth.logout()
    fun openTools() = moveForward(ELayerType.Tools, LayerTools.Info(auth.user.value?.email ?: "", auth.user.value?.password ?: ""))

    class Info : LayerBase.LayerInfo(ELayerType.Main)
}