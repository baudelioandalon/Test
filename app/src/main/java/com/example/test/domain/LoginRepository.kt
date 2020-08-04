package com.example.test.domain

import androidx.lifecycle.Observer
import com.example.test.data.datasource.web.LoginWebDS
import com.example.test.network.model.AuthResult
import com.example.test.sys.di.component.DaggerComponentLoginWebDS
import javax.inject.Inject

class LoginRepository @Inject constructor(){

    @Inject lateinit var loginWebDS: LoginWebDS

    init {
        DaggerComponentLoginWebDS.create().inject(this)
    }

    fun requestUserNetwork(user: String, password: String, observer: Observer<AuthResult>) {
        loginWebDS.requestUserNetwork(user, password, observer)
    }

}