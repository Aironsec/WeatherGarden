package ru.stplab.weathergarden.di.modules

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.stplab.weathergarden.mvp.modal.entity.room.db.Database
import ru.stplab.weathergarden.mvp.modal.entity.room.db.Database.Companion.DB_NAME
import ru.stplab.weathergarden.mvp.modal.repo.cache.CacheLocateCity
import ru.stplab.weathergarden.mvp.modal.repo.cache.CacheWeatherData
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheLocateCity
import ru.stplab.weathergarden.mvp.modal.repo.cache.ICacheWeatherData
import ru.stplab.weathergarden.ui.App
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun db(app: App): Database = Room.databaseBuilder(app, Database::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun dataWeatherCache(database: Database): ICacheWeatherData = CacheWeatherData(database)

    @Singleton
    @Provides
    fun locateCityCache(database: Database): ICacheLocateCity = CacheLocateCity(database)
}