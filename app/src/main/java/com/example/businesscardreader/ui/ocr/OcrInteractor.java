package com.example.businesscardreader.ui.ocr;

import com.google.android.gms.vision.text.TextBlock;

public class OcrInteractor {

    private TextBlock textBlockChecked;
    private static OcrInteractor ocrInteractor;

    private OcrInteractor(){

    }

    public static OcrInteractor getInstance(){
        if(ocrInteractor == null){
            ocrInteractor = new OcrInteractor();
        }
        return ocrInteractor;
    }

    void onTextBlockChenged(TextBlock textBlock){
        textBlockChecked = textBlock;
    }

    public TextBlock getTextBlockChecked() {
        return textBlockChecked;
    }
}
