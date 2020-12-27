package ru.stplab.weathergarden.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.stplab.weathergarden.R
import ru.stplab.weathergarden.databinding.DetailHourBottomSheetBinding
import ru.stplab.weathergarden.databinding.PageLocateFragmentBinding
import ru.stplab.weathergarden.mvp.presenter.WeatherPresenter
import ru.stplab.weathergarden.mvp.view.WeatherView
import ru.stplab.weathergarden.ui.App
import ru.stplab.weathergarden.ui.BackButtonListener
import ru.stplab.weathergarden.ui.adapter.WeatherRVAdapter

class PageLocateFragment : MvpAppCompatFragment(), WeatherView, BackButtonListener {

    companion object {
        fun newInstance() = PageLocateFragment()
    }

    private val binding by lazy { PageLocateFragmentBinding.inflate(layoutInflater) }


    private val adapter by lazy {
        WeatherRVAdapter(presenter.hoursListPresenter).apply { App.instance.appComponent.inject(this) }
    }

    private val presenter by moxyPresenter {
        WeatherPresenter().apply { App.instance.appComponent.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root


    override fun init() {
        binding.rvHourliesWeather.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHourliesWeather.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun updateCityNameSubCityName(city: String, subCity: String) {
        binding.toolbar.title = city
        binding.tvCitySubName.text = subCity
    }

    override fun showBottomSheet(pressure: String, humidity: String, speedWind: String) {
        // TODO: 28.12.2020 Как то сложновато !!! нужен другой способ
        with(binding.root) {
            findViewById<TextView>(R.id.tv_humidity).text = humidity
            findViewById<TextView>(R.id.tv_pressure).text = pressure
            findViewById<TextView>(R.id.tv_speed_wind).text = speedWind
        }
        val clBottomSheet = binding.root.findViewById<ConstraintLayout>(R.id.bottom_sheet)
        BottomSheetBehavior.from(clBottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun backPressed() = presenter.backClick()
}