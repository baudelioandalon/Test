package com.example.test.sys.di.module

import com.example.test.data.datasource.web.FileWebDS
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleFileWebDS{

    @Provides
    @Singleton
    fun providesFileWebDS(): FileWebDS {
        return FileWebDS()
    }
}