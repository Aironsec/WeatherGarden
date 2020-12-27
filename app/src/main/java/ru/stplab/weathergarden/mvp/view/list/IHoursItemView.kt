package ru.stplab.weathergarden.mvp.view.list

interface IHoursItemView: IItemView {
    fun loadImage(url: String)
    fun setTemps(temp: String)
    fun setHour(hour: String)
}