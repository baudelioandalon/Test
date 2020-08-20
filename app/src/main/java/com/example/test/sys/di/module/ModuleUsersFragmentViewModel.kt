package com.example.test.sys.di.module

import com.example.test.viewmodel.UsersFragmentViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleUsersFragmentViewModel {

    @Provides
    @Singleton
    fun providesUsersFragmentViewModel(): UsersFragmentViewModel{
        return UsersFragmentViewModel()
    }
}