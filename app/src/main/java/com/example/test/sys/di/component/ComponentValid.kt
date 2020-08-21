package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleValid
import com.example.test.ui.NewColaboradorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleValid::class])
interface ComponentValid {
    fun inject (newColaboradorActivity: NewColaboradorActivity)
}