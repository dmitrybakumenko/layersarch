package com.example.dmitrybak.myjetpack.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.dmitrybak.myjetpack.ProgramController
import com.example.dmitrybak.myjetpack.layer.ILayer
import com.example.dmitrybak.myjetpack.layer.LayerBase
import com.example.dmitrybak.myjetpack.ui.main.login.LayerLogin

open class VMLFBase<T : LayerBase>(app: Application) : AndroidViewModel(app) {

    protected var layer: T? = null

    protected fun compositor() = getApplication<ProgramController>().compositor

    fun layer(): LiveData<ILayer> = compositor().activeLayer

    open fun resume() {
        layer = compositor().activeLayer.value as? T
    }

    open fun pause() {}
}