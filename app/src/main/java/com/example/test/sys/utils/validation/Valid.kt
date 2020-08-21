package com.example.test.sys.utils.validation

import android.app.Activity
import android.util.Patterns
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.test.sys.utils.validation.enums.TypeActionFromValidation
import com.example.test.sys.utils.validation.enums.TypeComponent
import com.example.test.sys.utils.validation.enums.TypeValidation
import com.example.test.R
import com.example.test.sys.di.App
import com.example.test.sys.di.component.DaggerComponentPrettyToast
import com.example.test.sys.utils.PrettyToast
import com.example.test.sys.utils.validation.enums.TypePrettyToast
import com.tistory.zladnrms.roundablelayout.RoundableLayout
import javax.inject.Inject

class Valid @Inject constructor(){

    @Inject lateinit var prettyToast: PrettyToast
    init {
        DaggerComponentPrettyToast.create().inject(this)
    }

    /**
    *Este metodo funciona para validar EditText & Roundable
    *@author: Baudelio Andalon
    *@version: 11/08/2020
    *@param activity: Activity
    *@param element: Array<Element>
    *@return Boolean
    */
    fun isValid(activity: Activity, element: Array<Element>): Boolean {
        var result = false
        element.forEach{
            it.validationMetrics.forEach { validationMetrics ->
                when (validationMetrics.validation) {
                    TypeValidation.LIMIT -> {
                        when (it.typeComponent) {
                            TypeComponent.EDIT_TEXT -> {
                                when (validationMetrics.action) {
                                    TypeActionFromValidation.CHANGE_DRAWABLE -> {
                                        (it.element as EditText).apply {
                                            when{
                                                //Case 1
                                                text.toString().trim().isEmpty() ->{
                                                    background = ContextCompat.getDrawable(App.getAppContext(), R.drawable.simple_with_border_red)
                                                    error = if (validationMetrics.incorrect.isNullOrEmpty()) {
                                                        "Está vacío"
                                                    } else {
                                                        validationMetrics.incorrect
                                                    }
                                                    result = false
                                                }
                                                //Case 2
                                                text.toString().trim().length < validationMetrics.whichLimit!! -> {
                                                    background = ContextCompat.getDrawable(App.getAppContext(), R.drawable.simple_with_border_red)
                                                    error = if(validationMetrics.incorrect.isNullOrEmpty()) {
                                                        "Mínimo ${validationMetrics.whichLimit} caracteres"
                                                    } else {
                                                        validationMetrics.incorrect
                                                    }
                                                    result = false
                                                }
                                                //Case Else
                                                else -> {
                                                    background = ContextCompat.getDrawable(App.getAppContext(),R.drawable.simple_with_border_gray)
                                                    if(!validationMetrics.correct.isNullOrEmpty()){
                                                        prettyToast.showToast(
                                                            validationMetrics.correct,
                                                            TypePrettyToast.SUCCESS_TOAST,
                                                            activity)
                                                    }
                                                    result = true
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    TypeValidation.PICTURE -> {
                        when(it.typeComponent){
                            TypeComponent.ROUNDABLE -> {
                                when (validationMetrics.action) {
                                    TypeActionFromValidation.ADD_STROKE -> {
                                        (it.element as RoundableLayout).apply {
                                            when (validationMetrics.uriImage) {
                                                null -> {
                                                    strokeLineColor = ContextCompat.getColor(App.getAppContext(), R.color.red)
                                                    strokeLineWidth = 4f
                                                    result = false
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    TypeValidation.EMAIL -> {
                        when(it.typeComponent){
                            TypeComponent.EDIT_TEXT -> {
                                when (validationMetrics.action) {
                                    TypeActionFromValidation.CHANGE_DRAWABLE -> {
                                        (it.element as EditText).apply {
                                                when {
                                                    //Case 1
                                                    text.toString().trim().isEmpty() -> {
                                                        background = ContextCompat.getDrawable(App.getAppContext(), R.drawable.simple_with_border_red)
                                                        error = if (validationMetrics.incorrect.isNullOrEmpty()) {
                                                            "Está vacío"
                                                        } else {
                                                            validationMetrics.incorrect
                                                        }
                                                        result = false
                                                    }
                                                    //Case 2
                                                    !Patterns.EMAIL_ADDRESS.matcher(text.toString().trim()).matches() -> {
                                                        background = ContextCompat.getDrawable(App.getAppContext(), R.drawable.simple_with_border_red)
                                                        error = if(validationMetrics.incorrect.isNullOrEmpty()) {
                                                            "Correo no valido"
                                                        } else {
                                                            validationMetrics.incorrect
                                                        }
                                                        result = false
                                                    }
                                                    else -> {
                                                        background = ContextCompat.getDrawable(App.getAppContext(),R.drawable.simple_with_border_gray)
                                                        if(!validationMetrics.correct.isNullOrEmpty()){
                                                            prettyToast.showToast(
                                                                validationMetrics.correct,
                                                                TypePrettyToast.SUCCESS_TOAST,
                                                                activity)
                                                        }
                                                        result = true
                                                    }
                                                }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result
    }

}