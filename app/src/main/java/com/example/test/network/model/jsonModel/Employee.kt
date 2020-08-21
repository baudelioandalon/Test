package com.example.test.network.model.jsonModel

class Employee{
    var id: String = ""
    var location: Location = Location("","")
    var mail: String = ""
    var name: String = ""

    constructor()

    constructor(id: String, location: Location, mail: String, name: String){
        this.id = id
        this.location = location
        this.mail = mail
        this.name = name
    }
}