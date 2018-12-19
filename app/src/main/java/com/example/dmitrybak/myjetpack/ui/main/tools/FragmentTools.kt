package com.example.dmitrybak.myjetpack.ui.main.tools

import com.example.dmitrybak.myjetpack.R
import com.example.dmitrybak.myjetpack.ui.FragmentLayerBase
import kotlinx.android.synthetic.main.fragment_tools.*

class FragmentTools : FragmentLayerBase<VMFTools>(R.layout.fragment_tools) {
    override fun getClassViewModel() = VMFTools::class.java

    override fun onResume() {
        super.onResume()

        txtEmail.text = viewModel.email
        txtPassword.text = viewModel.password
    }
}
