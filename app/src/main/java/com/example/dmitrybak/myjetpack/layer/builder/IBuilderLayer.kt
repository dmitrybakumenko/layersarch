package com.example.dmitrybak.myjetpack.layer.builder

import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.LayerBase

interface IBuilderLayer {
    abstract fun build(layerType: ELayerType): LayerBase
}