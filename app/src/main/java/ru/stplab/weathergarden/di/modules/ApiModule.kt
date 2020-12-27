package ru.stplab.weathergarden.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.stplab.weathergarden.mvp.modal.api.IDataSource
import ru.stplab.weathergarden.mvp.modal.locate.ILocate
import ru.stplab.weathergarden.mvp.modal.network.INetworkState
import ru.stplab.weathergarden.ui.App
import ru.stplab.weathergarden.ui.locate.AndroidLocate
import ru.stplab.weathergarden.ui.network.AndroidNetworkState
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://api.openweathermap.org/"

    @Singleton
    @Provides
    fun client(): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(30, TimeUnit.SECONDS)
        .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    @Singleton
    @Provides
    fun gson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, client: OkHttpClient, gson: Gson): IDataSource = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(IDataSource::class.java)

    @Singleton
    @Provides
    fun networkState(app: App): INetworkState = AndroidNetworkState(app)

    @Singleton
    @Provides
    fun locate(app: App): ILocate = AndroidLocate(app)
}