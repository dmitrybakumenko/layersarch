package com.example.dmitrybak.myjetpack.quick_solution

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import android.os.Looper

class ServiceAuth(val prefs: Prefs) {
    val user: LiveData<User?> = MutableLiveData()

    init {
        (user as MutableLiveData).value = prefs.getUser()
    }

    fun isAuthorized() = user.value != null

    fun login(email: String, password: String, completion: (() -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed({
            val usr = User(email, password)
            prefs.setUser(usr)
            (user as MutableLiveData).value = usr
            completion?.let { it() }
        }, 100)
    }

    fun logout() {
        prefs.setUser(null)
        (user as MutableLiveData).value = null
    }

    class User(val email: String, val password: String)
}