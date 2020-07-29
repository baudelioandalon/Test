package com.example.test.data.datasource.web

import androidx.lifecycle.Observer
import com.example.test.model.AuthResult
import com.example.test.sys.di.module.enums.StartSessionResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class LoginWebDS @Inject constructor(){

    var auth: FirebaseAuth = FirebaseAuth.getInstance()
    fun requestUserNetwork(user: String, pass: String, observer: Observer<AuthResult>){
        auth.signInWithEmailAndPassword(user, pass)
                .addOnCompleteListener{
                    if (it.isSuccessful) observer.onChanged(AuthResult(StartSessionResult.CORRECT)) else observer.onChanged(AuthResult(StartSessionResult.INCORRECT))
                }
    }
}