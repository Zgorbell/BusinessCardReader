package com.example.businesscardreader.ui.ocr;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.android.gms.vision.text.TextBlock;

@InjectViewState
public class OcrPresenter extends MvpPresenter<OcrMvpView> {


    void onTextChecked(TextBlock textBlock){
        OcrInteractor.getInstance().onTextBlockChenged(textBlock);
        getViewState().finishActivityOk();
    }

}
