package ru.stplab.weathergarden.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.stplab.weathergarden.databinding.HourItemBinding
import ru.stplab.weathergarden.mvp.modal.image.IImageLoader
import ru.stplab.weathergarden.mvp.presenter.list.IHoursListPresenter
import ru.stplab.weathergarden.mvp.view.list.IHoursItemView
import javax.inject.Inject

class WeatherRVAdapter(val presenter: IHoursListPresenter): RecyclerView.Adapter<WeatherRVAdapter.ViewHolderI>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>
    lateinit var binding: HourItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherRVAdapter.ViewHolderI {
        binding = HourItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolderI(binding.root)
            .apply {
                containerView.setOnClickListener {
                    presenter.itemClickListener?.invoke(this)
                }
            }
    }


    override fun onBindViewHolder(holder: WeatherRVAdapter.ViewHolderI, position: Int) {
        holder.pos = position
        presenter.bindView(holder)
    }

    override fun getItemCount(): Int = presenter.getCount()

    inner class ViewHolderI(override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer, IHoursItemView {

        override var pos: Int = -1

        override fun setHour(hour: String) { binding.tvHour.text = hour }

        override fun loadImage(url: String) { imageLoader.loadIconWeather(url, binding.ivHour) }

        override fun setTemps(temp: String) { binding.tvTemp.text = temp }
    }
}