package com.example.dmitrybak.myjetpack.layer

abstract class LayerBase(info: LayerBase.LayerInfo) : ILayer {
    var owner: ILayerOwner? = null
    var info: LayerBase.LayerInfo = info
        private set(value) {
            field = value
        }

    fun activate(owner: ILayerOwner?) {
        this.owner = owner
    }

    fun deactivate() {
        this.owner = null
    }

    override fun type() = info.type
    override fun group() = info.type.group

    override fun hardBack(): Boolean = moveBack(null, null)
    override fun moveBack(layerType: ELayerType?, layerInfo: LayerBase.LayerInfo?): Boolean = owner?.moveBack(layerType, layerInfo) ?: false
    override fun moveForward(layerType: ELayerType, layerInfo: LayerBase.LayerInfo?) { owner?.moveForward(layerType, layerInfo)}

    fun useInfo(info: LayerBase.LayerInfo) {
        this.info = info
    }

    abstract class LayerInfo(val type: ELayerType)
}