package com.example.dmitrybak.myjetpack.layer.builder

import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.quick_solution.ServiceAuth
import com.example.dmitrybak.myjetpack.ui.main.login.LayerLogin
import com.example.dmitrybak.myjetpack.ui.main.main.LayerMain
import com.example.dmitrybak.myjetpack.ui.main.tools.LayerTools

class BuilderLayer(val owner: IOwner) : IBuilderLayer {
    interface IOwner{
        fun getAuth() : ServiceAuth
    }

    override fun build(layerType: ELayerType) =
        when (layerType) {
            ELayerType.Login -> LayerLogin(owner.getAuth())
            ELayerType.Main -> LayerMain(owner.getAuth())
            ELayerType.Tools -> LayerTools()
        }
}