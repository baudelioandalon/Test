package com.example.test.domain

import androidx.lifecycle.Observer
import com.example.test.data.datasource.local.DashboardUserLocalDS
import com.example.test.data.datasource.web.DashboardUserFirebaseDS
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.component.DaggerComponentDashboardUserFirebaseDS
import com.example.test.sys.di.component.DaggerComponentDashboardUserLocalDS
import com.google.android.gms.tasks.Task
import javax.inject.Inject

class DashboardUserRepository @Inject constructor() {

    @Inject lateinit var dashboardUserLocalDS: DashboardUserLocalDS
    @Inject lateinit var dashboardUserFirebaseDS: DashboardUserFirebaseDS

    init {
        DaggerComponentDashboardUserLocalDS.create().inject(this)
        DaggerComponentDashboardUserFirebaseDS.create().inject(this)
    }

    fun getLocalUsers(observer: Observer<ArrayList<Employee>>){
        dashboardUserLocalDS.getUsersFromSQL(observer)
    }

    fun setLocalUsers(jString: String){
        dashboardUserLocalDS.saveUsersToSQL(jString)
    }

    fun setFirebaseUsers(users: ArrayList<Employee>, observer: Observer<Task<Void>>){
        dashboardUserFirebaseDS.saveUsersToFirebase(users, observer)
    }
}