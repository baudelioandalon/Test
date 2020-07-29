package com.example.test.sys.di.component

import com.example.test.LoginActivity
import com.example.test.sys.di.module.ModulePrettyToast
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModulePrettyToast::class])
interface ComponentPrettyToast {
        fun inject(loginActivity: LoginActivity)
}