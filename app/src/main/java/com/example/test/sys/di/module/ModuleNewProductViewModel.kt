package com.example.test.sys.di.module

import com.example.test.viewmodel.NewColaboradorViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleNewProductViewModel {

    @Provides
    @Singleton
    fun providesNewColaboradorViewModel(): NewColaboradorViewModel {
        return NewColaboradorViewModel()
    }
}