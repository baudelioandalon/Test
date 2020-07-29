package com.example.test.sys.di.module

import com.example.test.viewmodel.LoginViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleLoginViewModel{

    @Provides
    @Singleton
    fun providesLoginViewModel(): LoginViewModel {
        return LoginViewModel()
    }
}