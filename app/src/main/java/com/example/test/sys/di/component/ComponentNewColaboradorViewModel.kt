package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleNewProductViewModel
import com.example.test.ui.NewColaboradorActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleNewProductViewModel::class])
interface ComponentNewColaboradorViewModel {
        fun inject(newColaboradorActivity: NewColaboradorActivity)
}