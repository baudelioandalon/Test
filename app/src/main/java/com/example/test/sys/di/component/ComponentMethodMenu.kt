package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleMethodMenu
import com.example.test.ui.InicioActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleMethodMenu::class])
interface ComponentMethodMenu {
        fun inject(inicioActivity: InicioActivity)
}