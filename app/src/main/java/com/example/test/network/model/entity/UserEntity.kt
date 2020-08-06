package com.example.test.network.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity {

    @PrimaryKey
    var id: Int = 0
    var name :  String = ""
    var mail : String = ""
}