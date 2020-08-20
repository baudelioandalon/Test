package com.example.test.sys.di.component

import com.example.test.domain.DashboardUserRepository
import com.example.test.sys.di.module.ModuleDashboardUserLocalDS
import com.example.test.sys.di.module.ModuleDashboardUserRepository
import com.example.test.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleDashboardUserLocalDS::class])
interface ComponentDashboardUserLocalDS {
    fun inject(dashboardUserRepository: DashboardUserRepository)
}