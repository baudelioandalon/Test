package com.example.test.sys.di.module

import com.example.test.viewmodel.MenuViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleMenuViewModel {
    @Provides
    @Singleton
    fun providesMenuViewModel() : MenuViewModel {
        return MenuViewModel()
    }

}