package com.example.test.sys.di.module

import com.example.test.sys.utils.TextChanged
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleTextChanged{

    @Provides
    @Singleton
    fun providesTextChanged(): TextChanged {
        return TextChanged()
    }

}