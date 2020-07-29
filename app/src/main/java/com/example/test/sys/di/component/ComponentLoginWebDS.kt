package com.example.test.sys.di.component

import com.example.test.domain.LoginRepository
import com.example.test.sys.di.module.ModuleLoginWebDS
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleLoginWebDS::class])
interface ComponentLoginWebDS {
        fun inject(loginRepository: LoginRepository)
}