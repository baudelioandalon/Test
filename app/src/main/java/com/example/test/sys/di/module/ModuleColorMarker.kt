package com.example.test.sys.di.module

import com.example.test.sys.utils.ColorMarker
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleColorMarker {

    @Provides
    @Singleton
    fun providesColorMarker(): ColorMarker {
        return ColorMarker()
    }
}