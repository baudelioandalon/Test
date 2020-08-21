package com.example.test.data.datasource.web

import androidx.lifecycle.Observer
import com.example.test.network.model.jsonModel.Employee
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import kotlin.collections.ArrayList

class DashboardUserFirebaseDS @Inject constructor() {

    private var database: DatabaseReference = FirebaseDatabase.getInstance().getReference("Test/Users")

    fun saveUsersToFirebase(users: ArrayList<Employee>, observer: Observer<Task<Void>>){
        val hashMap: HashMap<String, Any> = HashMap()
        users.forEach {
            hashMap[it.id] = it
        }
        database.setValue(hashMap).addOnCompleteListener{
            observer.onChanged(it)
        }
    }
}