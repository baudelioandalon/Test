package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleUserRepository
import com.example.test.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleUserRepository::class])
interface ComponentUserRepository {
    fun inject(menuViewModel: MenuViewModel)
}