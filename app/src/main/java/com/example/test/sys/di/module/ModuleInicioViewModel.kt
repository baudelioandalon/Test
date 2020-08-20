package com.example.test.sys.di.module

import com.example.test.viewmodel.InicioViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleInicioViewModel{

    @Provides
    @Singleton
    fun providesInicioViewModel(): InicioViewModel {
        return InicioViewModel()
    }
}