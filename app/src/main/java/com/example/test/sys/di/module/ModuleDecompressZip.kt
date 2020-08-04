package com.example.test.sys.di.module

import com.example.test.utils.DecompressZip
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ModuleDecompressZip {

    @Provides
    @Singleton
    fun providesDecompressZip() : DecompressZip {
        return DecompressZip()
    }
}