package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleLoginRepository
import com.example.test.viewmodel.LoginViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleLoginRepository::class])
interface ComponentLoginRepository {
        fun inject(loginViewModel: LoginViewModel)
}