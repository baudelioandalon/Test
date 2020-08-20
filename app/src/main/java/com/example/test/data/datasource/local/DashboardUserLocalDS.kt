package com.example.test.data.datasource.local

import androidx.lifecycle.Observer
import com.example.test.network.model.entity.UserEntity
import com.example.test.network.model.jsonModel.Employee
import com.example.test.network.model.jsonModel.Location
import com.example.test.network.model.jsonModel.UserModel
import com.example.test.sys.di.App
import com.google.gson.Gson
import javax.inject.Inject
import kotlin.collections.ArrayList

class DashboardUserLocalDS @Inject constructor() {

    fun getUsersFromSQL(observer: Observer<ArrayList<Employee>>){
        val list: ArrayList<Employee> = ArrayList()
        AppDB.get(App.getAppContext()).userDAO().getUser().forEach {
            it.apply {
                list.add(Employee(id.toString(), Location(lat,log),mail,name))
            }
        }
        observer.onChanged(list)
    }

    fun saveUsersToSQL(jString: String){
        val gson = Gson()
        val users: UserModel = gson.fromJson(jString, UserModel::class.java)
        val list: ArrayList<UserEntity> = ArrayList()
        users.data.employees.forEach {
            it.apply { list.add(UserEntity(id.toInt(),name,mail,location.lat,location.log)) }
        }
        AppDB.get(App.getAppContext()).userDAO().insertUser(list)
    }
}