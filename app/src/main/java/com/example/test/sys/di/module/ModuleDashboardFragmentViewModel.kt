package com.example.test.sys.di.module

import com.example.test.viewmodel.DashboardFragmentViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDashboardFragmentViewModel {

    @Provides
    @Singleton
    fun providesDashboardFragmentViewModel(): DashboardFragmentViewModel{
        return DashboardFragmentViewModel()
    }
}