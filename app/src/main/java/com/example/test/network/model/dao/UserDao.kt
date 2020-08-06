package com.example.test.network.model.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.test.network.model.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun saveUser(user: UserEntity)
}