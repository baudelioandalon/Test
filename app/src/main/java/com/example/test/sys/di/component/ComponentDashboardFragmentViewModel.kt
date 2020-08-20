package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleDashboardFragmentViewModel
import com.example.test.ui.DashboardFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleDashboardFragmentViewModel::class])
interface ComponentDashboardFragmentViewModel {
        fun inject(dashboardFragment: DashboardFragment)
}