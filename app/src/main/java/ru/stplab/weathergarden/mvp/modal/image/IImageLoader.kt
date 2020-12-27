package ru.stplab.weathergarden.mvp.modal.image

interface IImageLoader<T> {
    fun loadIconWeather(url: String, container: T)
}