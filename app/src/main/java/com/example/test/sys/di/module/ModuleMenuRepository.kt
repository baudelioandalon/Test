package com.example.test.sys.di.module

import com.example.test.domain.MenuRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleMenuRepository{

    @Provides
    @Singleton
    fun providesMenuRepository(): MenuRepository {
        return MenuRepository()
    }

}