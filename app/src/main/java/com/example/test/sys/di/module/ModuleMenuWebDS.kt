package com.example.test.sys.di.module

import com.example.test.data.datasource.web.MenuWebDS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleMenuWebDS{

    @Provides
    @Singleton
    fun providesMenuWebDS(): MenuWebDS {
        return MenuWebDS()
    }
}