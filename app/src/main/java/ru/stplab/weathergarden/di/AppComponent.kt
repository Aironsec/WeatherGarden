package ru.stplab.weathergarden.di

import dagger.Component
import ru.stplab.weathergarden.di.modules.ApiModule
import ru.stplab.weathergarden.di.modules.AppModule
import ru.stplab.weathergarden.di.modules.CacheModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CacheModule::class
    ]
)
interface AppComponent {
}