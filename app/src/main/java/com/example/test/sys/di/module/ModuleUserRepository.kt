package com.example.test.sys.di.module

import com.example.test.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleUserRepository {

    @Provides
    @Singleton
    fun providesUserRepository() : UserRepository {
        return UserRepository()
    }
}