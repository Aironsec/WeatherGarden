package ru.stplab.weathergarden.di.modules

import dagger.Module
import ru.stplab.weathergarden.ui.App
import javax.inject.Singleton

@Singleton
@Module
class AppModule(val app: App) {

}