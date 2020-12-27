package ru.stplab.weathergarden.di.modules

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.stplab.weathergarden.mvp.modal.image.IImageLoader
import ru.stplab.weathergarden.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun imageLoad(): IImageLoader<ImageView> = GlideImageLoader()
}