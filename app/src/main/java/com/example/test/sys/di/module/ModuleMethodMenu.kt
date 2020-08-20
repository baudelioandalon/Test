package com.example.test.sys.di.module

import com.example.test.sys.utils.MethodMenu
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleMethodMenu{

    @Provides
    @Singleton
    fun providesMethodMenu(): MethodMenu {
        return MethodMenu()
    }

}