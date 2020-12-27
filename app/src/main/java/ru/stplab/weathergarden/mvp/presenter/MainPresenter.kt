package ru.stplab.weathergarden.mvp.presenter

import moxy.MvpPresenter
import ru.stplab.weathergarden.mvp.view.MainView
import ru.stplab.weathergarden.navigation.Screens
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.checkPermissions()
    }

    fun exitApp() = router.exit()

    fun grantedPermissions(granted: Boolean) {
        if (!granted) viewState.requestPermissions()
        else router.replaceScreen(Screens.WeatherScreen())
    }

    fun responsePermission(response: Boolean) {
        if (response) router.replaceScreen(Screens.WeatherScreen())
        else exitApp()
    }
}