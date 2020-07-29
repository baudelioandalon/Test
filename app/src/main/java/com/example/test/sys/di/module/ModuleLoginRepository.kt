package com.example.test.sys.di.module

import com.example.test.domain.LoginRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleLoginRepository{

    @Provides
    @Singleton
    fun providesLoginRepository(): LoginRepository {
        return LoginRepository()
    }

}