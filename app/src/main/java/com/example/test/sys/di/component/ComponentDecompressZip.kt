package com.example.test.sys.di.component

import com.example.test.data.datasource.web.FileWebDS
import com.example.test.sys.di.module.ModuleDecompressZip
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleDecompressZip::class])
interface ComponentDecompressZip {
    fun inject(fileWebDS: FileWebDS)
}