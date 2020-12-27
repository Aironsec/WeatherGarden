package ru.stplab.weathergarden.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import ru.stplab.weathergarden.ui.App

@Module
class AppModule(private val app: App) {

    @Provides
    fun app(): App = app

    @Provides
    fun uiScheduler(): Scheduler = AndroidSchedulers.mainThread()
}