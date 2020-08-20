package com.example.test.domain

import androidx.lifecycle.Observer
import com.example.test.data.datasource.local.DashboardUserLocalDS
import com.example.test.network.model.jsonModel.Employee
import com.example.test.network.model.jsonModel.UserModel
import com.example.test.sys.di.component.DaggerComponentDashboardUserLocalDS
import javax.inject.Inject

class DashboardUserRepository @Inject constructor() {

    @Inject lateinit var dashboardUserLocalDS: DashboardUserLocalDS

    init {
        DaggerComponentDashboardUserLocalDS.create().inject(this)
    }

    fun getLocalUsers(observer: Observer<ArrayList<Employee>>){
        dashboardUserLocalDS.getUsersFromSQL(observer)
    }

    fun setLocalUsers(jString: String){
        dashboardUserLocalDS.saveUsersToSQL(jString)
    }
}