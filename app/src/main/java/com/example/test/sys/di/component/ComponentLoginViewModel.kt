package com.example.test.sys.di.component

import com.example.test.LoginActivity
import com.example.test.sys.di.module.ModuleLoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleLoginViewModel::class])
interface ComponentLoginViewModel {
        fun inject(loginActivity: LoginActivity)
}