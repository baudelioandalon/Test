package com.example.test.sys.di.module

import com.example.test.domain.DashboardUserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDashboardUserRepository {

    @Provides
    @Singleton
    fun providesDashboardUserRepository() : DashboardUserRepository {
        return DashboardUserRepository()
    }
}