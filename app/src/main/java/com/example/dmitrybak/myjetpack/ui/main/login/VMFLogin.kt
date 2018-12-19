package com.example.dmitrybak.myjetpack.ui.main.login

import android.app.Application
import com.example.dmitrybak.myjetpack.exceptions.ExceptionValidation
import com.example.dmitrybak.myjetpack.ui.VMLFBase
class VMFLogin(app: Application) : VMLFBase<LayerLogin>(app){
    var email: String
        get() = layer?.info()?.email ?: ""
        set(value) {layer?.info()?.email = value}

    var password: String
        get() = layer?.info()?.password ?: ""
        set(value) {layer?.info()?.password = value}

    fun login(email: String, password: String) {
        if (email.isEmpty())
            throw ExceptionValidation(ParamIdEmail, "Invalid Email")
        if(password.length < 7)
            throw ExceptionValidation(ParamIdPassword, "Password is to short please input minimum 7 symbols")

        layer?.login(email, password)
    }

    companion object {
        val ParamIdEmail = 1
        val ParamIdPassword = 2
    }
}
