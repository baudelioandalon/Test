package com.example.test.domain

import com.example.test.data.datasource.local.AppDB
import com.example.test.network.model.entity.UserEntity
import com.example.test.network.model.jsonModel.UserModel
import com.example.test.sys.di.App
import com.google.gson.Gson
import javax.inject.Inject

class UserRepository @Inject constructor() {

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