package com.example.dmitrybak.myjetpack.layer.compositor

import android.arch.lifecycle.LiveData
import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.ILayer

interface ICompositor {
    val activeLayer: LiveData<ILayer>
    fun reset(startPoint: ELayerType)
}