package com.example.businesscardreader.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.businesscardreader.R
import com.example.businesscardreader.R.id.textViewFirstName
import com.example.businesscardreader.ui.ocr.OcrCaptureActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainMvpView {

    private val TAG = MainActivity::class.java.simpleName
    private val OCR_ACTIVITY_RESULT = 1000
    @InjectPresenter
    lateinit var  mainPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFab()
    }

    private fun initFab() {
        findViewById<FloatingActionButton>(R.id.floatingActionButtonMain).setOnClickListener {
            startOpticalCharacterReaderActivity()
        }
    }

    private fun startOpticalCharacterReaderActivity() {
        val intent = Intent(this, OcrCaptureActivity::class.java)
        startActivityForResult(intent, OCR_ACTIVITY_RESULT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode ){
            Activity.RESULT_OK -> onActivityResultOk(requestCode, data)
            Activity.RESULT_CANCELED -> onActivityResultCanceled(requestCode)
        }
    }

    private fun onActivityResultOk(requestCode: Int, data: Intent?){
        when(requestCode){
            OCR_ACTIVITY_RESULT -> mainPresenter.onOcrActivityReturnResultOk()
        }
    }

    private fun onActivityResultCanceled(requestCode: Int){
        Log.d(TAG, "onActivityResult activity ${requestCode} canceled")
    }

    override fun setFirstName(firstName: String) {
        textViewFirstName.text = firstName
    }

    override fun setSecondName(secondName: String) {
        textViewSecondName.text = secondName
    }

    override fun setPhone(phone: String) {
        textViewPhone.text = phone
    }
}
