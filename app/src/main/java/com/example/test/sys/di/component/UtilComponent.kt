package com.example.test.sys.di.component

import android.content.Context
import com.example.test.sys.di.module.ModuleContext
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleContext::class])
interface UtilComponent {
    fun getAppContext(): Context
}