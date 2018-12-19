package com.example.dmitrybak.myjetpack.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dmitrybak.myjetpack.layer.LayerBase

abstract class FragmentLayerBase<T : VMLFBase<*>>(private val layoutId: Int) : Fragment() {
    protected lateinit var viewModel: T

    abstract fun getClassViewModel() : Class<T>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(getClassViewModel())
    }

    override fun onResume() {
        super.onResume()

        viewModel.resume()
    }

    override fun onPause() {
        super.onPause()

        viewModel.pause()
    }
}