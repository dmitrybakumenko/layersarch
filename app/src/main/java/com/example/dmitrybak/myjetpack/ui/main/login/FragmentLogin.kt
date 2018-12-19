package com.example.dmitrybak.myjetpack.ui.main.login

import android.os.Bundle
import android.view.View
import com.example.dmitrybak.myjetpack.R
import com.example.dmitrybak.myjetpack.exceptions.ExceptionValidation
import com.example.dmitrybak.myjetpack.ui.FragmentLayerBase
import kotlinx.android.synthetic.main.fragment_login.*

class FragmentLogin : FragmentLayerBase<VMFLogin>(R.layout.fragment_login) {
    override fun getClassViewModel() = VMFLogin::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener(::onClickLogin)
    }

    override fun onResume() {
        super.onResume()

        etxtEmail.setText(viewModel.email)
        etxtPassword.setText(viewModel.password)
    }

    override fun onPause() {
        viewModel.email = etxtEmail.text.toString()
        viewModel.password = etxtPassword.text.toString()

        super.onPause()
    }

    private fun onClickLogin(v: View) {
        etxtEmail.error = null
        etxtPassword.error = null

        try {
            viewModel.login(etxtEmail.text.toString().trim(), etxtPassword.text.toString())
        } catch (e: ExceptionValidation) {
            when (e.paramId) {
                VMFLogin.ParamIdEmail -> etxtEmail.error = e.msg
                VMFLogin.ParamIdPassword -> etxtPassword.error = e.msg
            }
        }
    }
}
