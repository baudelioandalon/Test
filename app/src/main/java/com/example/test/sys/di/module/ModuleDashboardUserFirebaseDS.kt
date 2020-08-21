package com.example.test.sys.di.module

import com.example.test.data.datasource.web.DashboardUserFirebaseDS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDashboardUserFirebaseDS {

    @Provides
    @Singleton
    fun providesDashboardUserFirebaseDS() : DashboardUserFirebaseDS {
        return DashboardUserFirebaseDS()
    }
}