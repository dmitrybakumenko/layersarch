package com.example.dmitrybak.myjetpack.ui.main.main

import android.os.Bundle
import android.view.View
import com.example.dmitrybak.myjetpack.R
import com.example.dmitrybak.myjetpack.ui.FragmentLayerBase
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : FragmentLayerBase<VMFMain>(R.layout.fragment_main) {
    override fun getClassViewModel() = VMFMain::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogout.setOnClickListener(::onClickLogout)
        btnTools.setOnClickListener(::onClickTools)
    }

    private fun onClickLogout(v: View){
        viewModel.onClickLogout()
    }

    private fun onClickTools(v: View){
        viewModel.onClickTools()
    }
}
