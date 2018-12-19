package com.example.dmitrybak.myjetpack.layer

enum class ELayerGroup() {
    Main
}

enum class ELayerType(val group: ELayerGroup) {
    Login(ELayerGroup.Main),
    Main(ELayerGroup.Main),
    Tools(ELayerGroup.Main)
}