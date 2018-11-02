package com.example.businesscardreader.ui.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.businesscardreader.ui.ocr.OcrInteractor
import com.google.android.gms.vision.text.TextBlock

@InjectViewState
class MainPresenter : MvpPresenter<MainMvpView>(){

    private lateinit var textBlockOcr: TextBlock


    fun onOcrActivityReturnResultOk(){
        textBlockOcr = OcrInteractor.getInstance().textBlockChecked
        viewState.setFirstName(textBlockOcr.value)
    }
}