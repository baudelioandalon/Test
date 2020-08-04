package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleFileRepository
import com.example.test.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleFileRepository::class])
interface ComponentFileRepository {
        fun inject(menuViewModel: MenuViewModel)
}