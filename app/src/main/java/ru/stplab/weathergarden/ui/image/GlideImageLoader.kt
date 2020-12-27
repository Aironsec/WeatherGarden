package ru.stplab.weathergarden.ui.image

import android.widget.ImageView
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions.withCrossFade
import ru.stplab.weathergarden.mvp.modal.image.IImageLoader

class GlideImageLoader: IImageLoader<ImageView> {
    override fun loadIconWeather(url: String, container: ImageView) {
        GlideApp.with(container.context)
            .asBitmap()
            .circleCrop()
            .transition(withCrossFade())
            .load(url)
            .into(container)
    }
}