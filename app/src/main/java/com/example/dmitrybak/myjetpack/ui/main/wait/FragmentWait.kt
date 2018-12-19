package com.example.dmitrybak.myjetpack.ui.main.wait

import com.example.dmitrybak.myjetpack.R
import com.example.dmitrybak.myjetpack.ui.FragmentLayerBase
import com.example.dmitrybak.myjetpack.ui.VMLFBase

class FragmentWait : FragmentLayerBase<VMLFBase<*>>(R.layout.fragment_wait){
    override fun getClassViewModel() = VMLFBase::class.java
}