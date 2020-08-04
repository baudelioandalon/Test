package com.example.test.domain

import androidx.lifecycle.Observer
import com.example.test.data.datasource.web.MenuWebDS
import com.example.test.network.model.Data
import com.example.test.sys.di.component.DaggerComponentMenuWebDS
import javax.inject.Inject

class MenuRepository @Inject constructor(){

    @Inject lateinit var menuWebDS: MenuWebDS

    init {
        DaggerComponentMenuWebDS.create().inject(this)
    }

    fun requestDataFromNetwork(searchString: String, observer: Observer<Data>) {
        menuWebDS.requestUserNetwork(searchString, observer)
    }

}