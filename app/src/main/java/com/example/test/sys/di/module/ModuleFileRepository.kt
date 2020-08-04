package com.example.test.sys.di.module

import com.example.test.domain.FileRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleFileRepository{

    @Provides
    @Singleton
    fun providesFileRepository(): FileRepository {
        return FileRepository()
    }

}