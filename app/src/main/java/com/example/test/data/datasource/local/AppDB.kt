package com.example.test.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.network.model.dao.UserDao
import com.example.test.network.model.entity.UserEntity

@Database(entities = [(UserEntity::class)], version = 1)
abstract class AppDB: RoomDatabase() {
    companion object {
        fun get(context: Context): AppDB{
            return Room.databaseBuilder(context, AppDB::class.java,"usersDB").allowMainThreadQueries().build()
        }
    }
    abstract fun userDAO() : UserDao
}