package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleMenuRepository
import com.example.test.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleMenuRepository::class])
interface ComponentMenuRepository {
        fun inject(menuViewModel: MenuViewModel)
}