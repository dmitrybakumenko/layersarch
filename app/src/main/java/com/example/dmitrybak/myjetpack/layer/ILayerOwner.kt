package com.example.dmitrybak.myjetpack.layer

interface ILayerOwner {
    fun moveForward(layerType: ELayerType, layerInfo: LayerBase.LayerInfo? = null)
    fun moveBack(layerType: ELayerType? = null, layerInfo: LayerBase.LayerInfo? = null): Boolean
}