package com.example.test.network.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class UserEntity {

    @PrimaryKey
    var id: Int = 0
    var name :  String = ""
    var mail : String = ""
    var lat : String = ""
    var log : String = ""

    constructor(id: Int, name: String, mail: String, lat: String, log: String){
        this.id = id
        this.name = name
        this.mail = mail
        this.lat = lat
        this.log = log
    }
}