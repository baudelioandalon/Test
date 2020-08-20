package com.example.test.sys.di.module

import com.example.test.sys.utils.menusliding.StatusBarChangeColor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleStatusBarChangeColor{

    @Provides
    @Singleton
    fun providesStatusBarChangeColor(): StatusBarChangeColor {
        return StatusBarChangeColor()
    }

}