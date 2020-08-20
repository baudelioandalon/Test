package com.example.test.domain

import com.example.test.data.datasource.local.AppDB
import com.example.test.data.datasource.local.DashboardUserLocalDS
import com.example.test.network.model.entity.UserEntity
import com.example.test.network.model.jsonModel.UserModel
import com.example.test.sys.di.App
import com.example.test.sys.di.component.DaggerComponentDashboardUserLocalDS
import com.google.gson.Gson
import javax.inject.Inject

class DashboardUserRepository @Inject constructor() {

    @Inject lateinit var dashboardUserLocalDS: DashboardUserLocalDS

    init {
        DaggerComponentDashboardUserLocalDS.create().inject(this)
    }

    fun getLocalUsers(){

    }

    fun saveUsers(jString: String){
        val gson = Gson()
        val users: UserModel = gson.fromJson(jString, UserModel::class.java)
        val list: ArrayList<UserEntity> = ArrayList()
        users.data.employees.forEach {
            it.apply { list.add(UserEntity(id.toInt(),name,mail,location.lat,location.log)) }
        }
        AppDB.get(App.getAppContext()).userDAO().insertUser(list)
    }

}