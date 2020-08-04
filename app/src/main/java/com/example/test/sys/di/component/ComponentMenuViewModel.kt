package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleMenuViewModel
import com.example.test.ui.MenuPrincipal
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleMenuViewModel::class])
interface ComponentMenuViewModel {
        fun inject(menuPrincipal: MenuPrincipal)
}