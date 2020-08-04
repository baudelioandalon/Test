package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleLoginViewModel
import com.example.test.ui.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleLoginViewModel::class])
interface ComponentLoginViewModel {
        fun inject(loginActivity: LoginActivity)
}