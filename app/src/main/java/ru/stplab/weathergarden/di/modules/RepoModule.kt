package ru.stplab.weathergarden.di.modules

import dagger.Module
import dagger.Provides
import ru.stplab.weathergarden.mvp.modal.api.IDataSource
import ru.stplab.weathergarden.mvp.modal.locate.ILocate
import ru.stplab.weathergarden.mvp.modal.network.INetworkState
import ru.stplab.weathergarden.mvp.modal.repo.ILocateCityRepo
import ru.stplab.weathergarden.mvp.modal.repo.IWeatherDataRepo
import ru.stplab.weathergarden.mvp.modal.repo.LocateCityRepo
import ru.stplab.weathergarden.mvp.modal.repo.RetrofitWeatherDataRepo
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheLocateCity
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheWeatherData
import ru.stplab.weathergarden.ui.App
import javax.inject.Singleton

@Module
class RepoModule {

    @Singleton
    @Provides
    fun weatherDataRepo(
        api: IDataSource,
        dataWeatherCache: ICacheWeatherData,
        networkStatus: INetworkState
    ): IWeatherDataRepo = RetrofitWeatherDataRepo(networkStatus, api, dataWeatherCache)

    @Singleton
    @Provides
    fun cityRepo(
        locate: ILocate,
        locateCityCache: ICacheLocateCity
    ): ILocateCityRepo = LocateCityRepo(locate, locateCityCache)

}