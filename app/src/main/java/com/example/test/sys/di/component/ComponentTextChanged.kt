package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleTextChanged
import com.example.test.ui.NewColaboradorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleTextChanged::class])
interface ComponentTextChanged {
        fun inject(newColaboradorActivity: NewColaboradorActivity)
}