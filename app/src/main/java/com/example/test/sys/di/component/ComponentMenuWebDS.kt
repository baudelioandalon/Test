package com.example.test.sys.di.component

import com.example.test.domain.MenuRepository
import com.example.test.sys.di.module.ModuleMenuWebDS
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleMenuWebDS::class])
interface ComponentMenuWebDS {
        fun inject(menuRepository: MenuRepository)
}