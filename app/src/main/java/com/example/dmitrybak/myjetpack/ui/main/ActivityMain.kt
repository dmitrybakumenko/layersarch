package com.example.dmitrybak.myjetpack.ui.main

import com.example.dmitrybak.myjetpack.R
import com.example.dmitrybak.myjetpack.layer.ELayerGroup
import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.ui.ActivityLayerBase

class ActivityMain : ActivityLayerBase<VMAMain>(R.layout.activity_main, R.id.fragmentNavigation) {
    override fun getClassViewModel() = VMAMain::class.java

    override fun getLayerGroup() = ELayerGroup.Main

    override fun getLayerGroupClass(layerGroup: ELayerGroup) = when(layerGroup){
        ELayerGroup.Main -> ActivityMain::class.java
    }

    override fun getLayerFragmentId(layerType: ELayerType) = when (layerType) {
        ELayerType.Login -> R.id.fragmentLogin
        ELayerType.Main -> R.id.fragmentMain
        ELayerType.Tools -> R.id.fragmentTools
    }
}