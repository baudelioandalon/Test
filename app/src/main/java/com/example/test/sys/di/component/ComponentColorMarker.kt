package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleColorMarker
import com.example.test.ui.DashboardFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleColorMarker::class])
interface ComponentColorMarker {
    fun inject(dashboardFragment: DashboardFragment)
}