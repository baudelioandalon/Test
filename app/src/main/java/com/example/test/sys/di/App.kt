package com.example.test.sys.di

import android.app.Application
import android.content.Context
import com.example.test.sys.di.component.DaggerUtilComponent
import com.example.test.sys.di.component.UtilComponent
import com.example.test.sys.di.module.ModuleContext

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        utilComponent = DaggerUtilComponent.builder().moduleContext(ModuleContext(applicationContext)).build()
//        DaggerComponentLoginViewModel.builder().build()
    }

    companion object {
        lateinit var utilComponent: UtilComponent

        fun getAppContext(): Context {
            return utilComponent.getAppContext()
        }
    }
}