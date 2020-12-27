package ru.stplab.weathergarden.navigation

import ru.stplab.weathergarden.ui.fragment.PageLocateFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class WeatherScreen: SupportAppScreen(){
        override fun getFragment() = PageLocateFragment.newInstance()
    }
}