package ru.stplab.weathergarden.di

import dagger.Component
import ru.stplab.weathergarden.di.modules.*
import ru.stplab.weathergarden.ui.activity.MainActivity
import ru.stplab.weathergarden.mvp.presenter.MainPresenter
import ru.stplab.weathergarden.mvp.presenter.WeatherPresenter
import ru.stplab.weathergarden.ui.adapter.WeatherRVAdapter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        CacheModule::class,
        NavigationModule::class,
        ImageModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(weatherPresenter: WeatherPresenter)
    fun inject(weatherRVAdapter: WeatherRVAdapter)

}