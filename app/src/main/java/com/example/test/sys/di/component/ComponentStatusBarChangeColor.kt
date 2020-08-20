package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleStatusBarChangeColor
import com.example.test.ui.InicioActivity
import com.example.test.ui.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleStatusBarChangeColor::class])
interface ComponentStatusBarChangeColor {
        fun inject(loginActivity: LoginActivity)
        fun inject(inicioActivity: InicioActivity)
}