package com.example.test.sys.di.component

import com.example.test.domain.FileRepository
import com.example.test.sys.di.module.ModuleFileWebDS
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleFileWebDS::class])
interface ComponentFileWebDS {
        fun inject(fileRepository: FileRepository)
}