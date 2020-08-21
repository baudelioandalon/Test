package com.example.test.sys.di.module

import com.example.test.sys.utils.validation.Valid
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleValid{

    @Provides
    @Singleton
    fun providesValid(): Valid {
        return Valid()
    }
}