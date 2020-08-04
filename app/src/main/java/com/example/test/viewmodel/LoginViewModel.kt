package com.example.test.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.test.domain.LoginRepository
import com.example.test.network.model.AuthResult
import com.example.test.sys.di.component.DaggerComponentLoginRepository
import com.example.test.sys.di.module.enums.StartSessionResult
import javax.inject.Inject

class LoginViewModel @Inject constructor():ViewModel(), LifecycleObserver {

    //Dagger
    @Inject lateinit var loginRepository: LoginRepository

    var onRequestLoginSuccessful: MutableLiveData<AuthResult> = MutableLiveData()
    var loggingUser: MutableLiveData<Boolean> = MutableLiveData(false)

    fun requestLogin(user: String, password: String) {
        DaggerComponentLoginRepository.create().inject(this)
        loginRepository.requestUserNetwork(user, password, buildGetLoginResponseObserve())
    }

    private fun buildGetLoginResponseObserve(): Observer<AuthResult> {
        return Observer { response ->
            if (response != null) {
                onRequestLoginSuccessful.postValue(response)
                if(response.sessionCode != StartSessionResult.CORRECT) loggingUser.postValue(false) else loggingUser.postValue(true)
            }else{
                loggingUser.postValue(false)
            }
        }
    }
}