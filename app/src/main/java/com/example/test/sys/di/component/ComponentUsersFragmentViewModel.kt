package com.example.test.sys.di.component

import com.example.test.sys.di.module.ModuleUsersFragmentViewModel
import com.example.test.ui.UsersFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleUsersFragmentViewModel::class])
interface ComponentUsersFragmentViewModel {
        fun inject(usersFragment: UsersFragment)
}