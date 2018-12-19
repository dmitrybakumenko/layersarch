package com.example.dmitrybak.myjetpack.layer.compositor

import android.arch.lifecycle.MutableLiveData
import com.example.dmitrybak.myjetpack.layer.*
import com.example.dmitrybak.myjetpack.layer.builder.IBuilderLayer
import java.util.*

class Compositor(val builder: IBuilderLayer) : ICompositor, ILayerOwner {
    private val holder = HolderLayers()
    private val stack = Stack<LayerBase.LayerInfo>()

    override val activeLayer: MutableLiveData<ILayer> = MutableLiveData()

    override fun reset(startPoint: ELayerType) {
        stack.clear()
        applyLayer(startPoint)
    }

    override fun moveForward(layerType: ELayerType, layerInfo: LayerBase.LayerInfo?) {
        val layer = activeLayer.value
        if (layer is LayerBase)
            stack.push(layer.info)

        applyLayer(layerType, layerInfo)
    }

    override fun moveBack(layerType: ELayerType?, layerInfo: LayerBase.LayerInfo?): Boolean {
        val info: LayerBase.LayerInfo? = spinStack(layerType ?: layerInfo?.type)
        val type: ELayerType? = info?.type ?: layerType
        return if (type != null) {
            applyLayer(type, layerInfo)
            true
        } else false
    }

    private fun spinStack(layerType: ELayerType?): LayerBase.LayerInfo? {
        if (layerType != null) {
            while (true) {
                if (stack.size == 0)
                    break

                val popInfo = stack.pop()
                if (popInfo.type == layerType) {
                    return popInfo
                }
            }
        } else {
            if (stack.size > 0)
                return stack.pop()
        }

        return null
    }

    private fun applyLayer(layerType: ELayerType, info: LayerBase.LayerInfo? = null) {
        val layer: LayerBase = holder.fetch(layerType)
        if (info != null)
            layer.useInfo(info)

        val prevLayer = activeLayer.value
        if (prevLayer is LayerBase) prevLayer.deactivate()

        layer.activate(this)
        activeLayer.value = layer
    }

    inner class HolderLayers {
        private val mapLayers: MutableMap<ELayerType, LayerBase> = mutableMapOf()

        fun fetch(layerType: ELayerType): LayerBase = mapLayers[layerType] ?: createLayer(layerType)

        private fun createLayer(layerType: ELayerType): LayerBase {
            val layer = builder.build(layerType)
            mapLayers[layerType] = layer
            return layer
        }
    }
}