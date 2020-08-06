package com.example.test.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test.network.model.dao.UserDao
import com.example.test.network.model.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class AppDB: RoomDatabase() {
    abstract fun userDAO() : UserDao
}