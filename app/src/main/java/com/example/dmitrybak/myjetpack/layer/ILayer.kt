package com.example.dmitrybak.myjetpack.layer

interface ILayer {
    fun type() : ELayerType
    fun group() : ELayerGroup
    fun hardBack() : Boolean
    fun moveBack(layerType: ELayerType? = null, layerInfo: LayerBase.LayerInfo? = null) : Boolean
    fun moveForward(layerType: ELayerType, layerInfo: LayerBase.LayerInfo? = null)
}