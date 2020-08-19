package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleDecompressZip
import com.example.test.viewmodel.MenuViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleDecompressZip::class])
interface ComponentDecompressZip {
    fun inject(menuViewModel: MenuViewModel)
}