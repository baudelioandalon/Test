package com.example.test.sys.utils

import android.app.Activity
import android.view.Gravity
import com.onurkaganaldemir.ktoastlib.KToast
import javax.inject.Inject

class PrettyToast @Inject constructor(){

    fun showToast(text: String, type: TypePrettyToast, activity: Activity){
        when(type){
            TypePrettyToast.SUCCESS_TOAST -> KToast.successToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
            TypePrettyToast.WARNING_TOAST -> KToast.warningToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
            TypePrettyToast.ERROR_TOAST -> KToast.errorToast(activity, text, Gravity.BOTTOM, KToast.LENGTH_AUTO)
        }
    }
}