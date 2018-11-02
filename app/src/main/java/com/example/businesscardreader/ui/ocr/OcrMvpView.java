package com.example.businesscardreader.ui.ocr;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

interface OcrMvpView extends MvpView {

    @StateStrategyType(SkipStrategy.class)
    void finishActivityOk();

    @StateStrategyType(SkipStrategy.class)
    void finishActivityCancel();
}
