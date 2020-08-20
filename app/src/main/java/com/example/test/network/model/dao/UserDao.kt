package com.example.test.network.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test.network.model.entity.UserEntity
import com.example.test.network.model.jsonModel.UserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(list: ArrayList<UserEntity>)

    @Query("SELECT * FROM users")
    fun getUser() : List<UserEntity>
}