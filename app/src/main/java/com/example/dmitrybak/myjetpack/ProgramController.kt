package com.example.dmitrybak.myjetpack

import android.app.Application
import android.arch.lifecycle.Observer
import android.content.Context
import com.example.dmitrybak.myjetpack.layer.builder.BuilderLayer
import com.example.dmitrybak.myjetpack.layer.compositor.Compositor
import com.example.dmitrybak.myjetpack.layer.ELayerType
import com.example.dmitrybak.myjetpack.layer.builder.IBuilderLayer
import com.example.dmitrybak.myjetpack.layer.compositor.ICompositor
import com.example.dmitrybak.myjetpack.quick_solution.Prefs
import com.example.dmitrybak.myjetpack.quick_solution.ServiceAuth

class ProgramController : Application() {
    lateinit var compositor: ICompositor
    lateinit var serviceAuth: ServiceAuth

    override fun onCreate() {
        super.onCreate()

        compositor = Compositor(BuilderLayer(BuilderOwner()))


        // TODO: Need to create compositor wrapper with flow's hot points, something like Login or Order change
        serviceAuth = ServiceAuth(Prefs(getSharedPreferences("com.example.dmitrybak.myjetpack", Context.MODE_PRIVATE)))
        serviceAuth.user.observeForever(ObserverUser())
        if (serviceAuth.isAuthorized())
            compositor.reset(ELayerType.Main)
    }

    private inner class ObserverUser : Observer<ServiceAuth.User?> {
        override fun onChanged(user: ServiceAuth.User?) {
            if (user == null)
                compositor.reset(ELayerType.Login)
        }
    }

    inner class BuilderOwner : BuilderLayer.IOwner {
        override fun getAuth() = serviceAuth
    }
}