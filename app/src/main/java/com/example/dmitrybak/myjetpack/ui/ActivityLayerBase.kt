package com.example.dmitrybak.myjetpack.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.dmitrybak.myjetpack.layer.ELayerGroup
import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.ILayer

abstract class ActivityLayerBase<T : VMLABase>(private val idLayout: Int, private val idNavController: Int) :
    FragmentActivity() {

    protected lateinit var viewModel: T
    private lateinit var navigation: NavController

    abstract fun getLayerGroupClass(layerGroup: ELayerGroup): Class<*>

    abstract fun getClassViewModel(): Class<T>

    abstract fun getLayerGroup(): ELayerGroup

    abstract fun getLayerFragmentId(layerType: ELayerType): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(idLayout)

        navigation = Navigation.findNavController(this, idNavController)
        viewModel = ViewModelProviders.of(this).get(getClassViewModel())
        viewModel.layer().observe(this, ObserverLayer())
    }

    protected open fun onLayerChanged(layerType: ELayerType) {
        if (layerType.group != getLayerGroup()) {
            startActivity(Intent(this, getLayerGroupClass(layerType.group)))
            overridePendingTransition(-1, -1)
            finish()
        } else {
            val destinationId = getLayerFragmentId(layerType)
            val destination = navigation.currentDestination
            if (destination?.id != destinationId) {
                val navBuilder = NavOptions.Builder().setPopUpTo(destinationId, true)
                navBuilder.setEnterAnim(android.R.anim.fade_in).setExitAnim(android.R.anim.fade_out)
                navigation.navigate(destinationId, null, navBuilder.build())
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.backPressed())
            super.onBackPressed()
    }

    private inner class ObserverLayer : Observer<ILayer> {
        override fun onChanged(layer: ILayer?) {
            if (layer != null)
                onLayerChanged(layer.type())
        }
    }
}