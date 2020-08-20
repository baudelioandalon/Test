package com.example.test.sys.di.module

import com.example.test.sys.utils.PrettyToast
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModulePrettyToast{

    @Provides
    @Singleton
    fun providesPrettyToast(): PrettyToast {
        return PrettyToast()
    }

}