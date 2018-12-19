package com.example.dmitrybak.myjetpack.ui.main.login

import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.LayerBase
import com.example.dmitrybak.myjetpack.quick_solution.ServiceAuth

open class LayerLogin(val auth: ServiceAuth, info : LayerLogin.Info = LayerLogin.Info()) : LayerBase(info) {

    fun info() : LayerLogin.Info = info as Info

    fun login(email: String, password: String) {
        auth.login(email, password){
            moveForward(ELayerType.Main)
        }
    }

    override fun hardBack() = true

    class Info: LayerBase.LayerInfo(ELayerType.Login){
        var email : String = ""
        var password : String = ""
    }
}