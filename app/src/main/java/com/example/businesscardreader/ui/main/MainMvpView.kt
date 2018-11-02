package com.example.businesscardreader.ui.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

interface MainMvpView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setFirstName(firstName: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setSecondName(secondName: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setPhone(phone: String)
}