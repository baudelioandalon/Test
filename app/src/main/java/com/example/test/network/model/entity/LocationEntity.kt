package com.example.test.network.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class LocationEntity {
    @PrimaryKey
    var id: Int = 1
    var lat :  String = ""
    var log : String = ""
}