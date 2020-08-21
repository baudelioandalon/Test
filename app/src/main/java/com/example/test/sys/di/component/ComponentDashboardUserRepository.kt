package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleDashboardUserRepository
import com.example.test.viewmodel.DashboardFragmentViewModel
import com.example.test.viewmodel.MenuViewModel
import com.example.test.viewmodel.UsersFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleDashboardUserRepository::class])
interface ComponentDashboardUserRepository {
    fun inject(menuViewModel: MenuViewModel)
    fun inject(dashboardFragmentViewModel: DashboardFragmentViewModel)
    fun inject(usersFragmentViewModel: UsersFragmentViewModel)
}