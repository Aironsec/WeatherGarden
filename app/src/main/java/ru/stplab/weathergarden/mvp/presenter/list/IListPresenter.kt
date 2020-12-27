package ru.stplab.weathergarden.mvp.presenter.list

import ru.stplab.weathergarden.mvp.view.list.IItemView

interface IListPresenter<V: IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}