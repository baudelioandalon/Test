package com.example.test.sys.di.module

import com.example.test.data.datasource.web.LoginWebDS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleLoginWebDS{

    @Provides
    @Singleton
    fun providesLoginWebDS(): LoginWebDS {
        return LoginWebDS()
    }
}