package com.example.test.sys.di

import android.app.Application
import android.content.Context
import com.example.test.sys.di.component.*
import com.example.test.sys.di.module.ModuleContext

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        utilComponent = DaggerUtilComponent.builder().moduleContext(ModuleContext(applicationContext)).build()
        DaggerComponentLoginViewModel.builder().build()
        DaggerComponentMenuViewModel.builder().build()
        DaggerComponentLoginRepository.builder().build()
        DaggerComponentLoginWebDS.builder().build()
        DaggerComponentPrettyToast.builder().build()
        DaggerComponentMenuWebDS.builder().build()
        DaggerComponentMenuRepository.builder().build()
        DaggerComponentFileRepository.builder().build()
        DaggerComponentDecompressZip.builder().build()
        DaggerComponentUserRepository.builder().build()
        DaggerComponentDashboardFragmentViewModel.builder().build()
        DaggerComponentUsersFragmentViewModel.builder().build()
    }

    companion object {
        lateinit var utilComponent: UtilComponent

        fun getAppContext(): Context {
            return utilComponent.getAppContext()
        }
    }
}