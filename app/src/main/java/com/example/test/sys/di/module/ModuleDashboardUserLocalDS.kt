package com.example.test.sys.di.module

import com.example.test.data.datasource.local.DashboardUserLocalDS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDashboardUserLocalDS {

    @Provides
    @Singleton
    fun providesDashboardUserLocalDS() : DashboardUserLocalDS {
        return DashboardUserLocalDS()
    }
}