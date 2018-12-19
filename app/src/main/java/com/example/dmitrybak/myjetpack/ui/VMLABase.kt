package com.example.dmitrybak.myjetpack.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.dmitrybak.myjetpack.ProgramController
import com.example.dmitrybak.myjetpack.layer.ILayer

open class VMLABase(app: Application) : AndroidViewModel(app){
    protected fun compositor() = getApplication<ProgramController>().compositor
    fun layer(): LiveData<ILayer> = compositor().activeLayer
    fun backPressed() = layer().value?.hardBack() ?: true
}