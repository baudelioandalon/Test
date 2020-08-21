package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModulePrettyToast
import com.example.test.sys.utils.validation.Valid
import com.example.test.ui.LoginActivity
import com.example.test.ui.MenuPrincipal
import com.example.test.ui.NewColaboradorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModulePrettyToast::class])
interface ComponentPrettyToast {
        fun inject(loginActivity: LoginActivity)
        fun inject(menuPrincipal: MenuPrincipal)
        fun inject(valid: Valid)
        fun inject(newColaboradorActivity: NewColaboradorActivity)
}