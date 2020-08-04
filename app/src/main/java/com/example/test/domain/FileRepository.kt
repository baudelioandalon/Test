package com.example.test.domain

import androidx.lifecycle.Observer
import com.example.test.data.datasource.web.FileWebDS
import com.example.test.network.model.Data
import com.example.test.sys.di.component.DaggerComponentFileWebDS
import javax.inject.Inject

class FileRepository @Inject constructor(){

    @Inject lateinit var fileWebDS: FileWebDS

    init {
        DaggerComponentFileWebDS.create().inject(this)
    }

    fun requestFileFromNetwork(url: String, observer: Observer<Data>) {
        fileWebDS.requestFileFromNetwork(url, observer)
    }

}