package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleInicioViewModel
import com.example.test.ui.InicioActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleInicioViewModel::class])
interface ComponentInicioViewModel {
        fun inject(inicioActivity: InicioActivity)
}