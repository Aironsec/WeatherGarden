package ru.stplab.weathergarden.ui

import android.app.Application
import ru.stplab.weathergarden.di.AppComponent
import ru.stplab.weathergarden.di.DaggerAppComponent
import ru.stplab.weathergarden.di.modules.AppModule

class App: Application() {

    companion object{
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}