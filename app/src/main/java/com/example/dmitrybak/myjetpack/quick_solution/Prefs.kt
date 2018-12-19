package com.example.dmitrybak.myjetpack.quick_solution

import android.content.SharedPreferences

class Prefs(val sharedPrefs: SharedPreferences) {
    fun setUser(user: ServiceAuth.User?) {
        val edit = sharedPrefs.edit()
        if (user == null) {
            edit.remove("password")
            edit.remove("email")
        } else {
            edit.putString("password", user.password)
            edit.putString("email", user.email)
        }
        edit.apply()
    }

    fun getUser(): ServiceAuth.User? {
        val password = sharedPrefs.getString("password", null)
        val email = sharedPrefs.getString("email", null)

        if (password != null && email != null) {
            return ServiceAuth.User(email, password)
        }
        return null
    }
}