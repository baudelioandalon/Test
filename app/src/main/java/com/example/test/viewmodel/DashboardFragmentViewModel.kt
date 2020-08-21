package com.example.test.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.test.domain.DashboardUserRepository
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.component.DaggerComponentDashboardUserRepository
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.launch
import javax.inject.Inject

class DashboardFragmentViewModel @Inject constructor() : ViewModel(){

    @Inject lateinit var dashboardUserRepository: DashboardUserRepository
    val users: MutableLiveData<ArrayList<Employee>> = MutableLiveData()
    var mMap : GoogleMap? = null

    init {
        DaggerComponentDashboardUserRepository.create().inject(this)
    }

    fun sendUsers(users: ArrayList<Employee>){
        viewModelScope.launch {
            dashboardUserRepository.setFirebaseUsers(users, observerSetFirebase())
        }
    }

    private fun observerSetFirebase(): Observer<Task<Void>>{
        return Observer {
            if(it.isSuccessful){
                Log.e("Firebase","Usuarios actualizados")
            }else{
                Log.e("Firebase","Usuarios no actualizados")
            }
        }
    }

    fun requestLocalUsers(){
        viewModelScope.launch {
            dashboardUserRepository.getLocalUsers(observerLocalUsers())
        }
    }

    private fun observerLocalUsers(): Observer<ArrayList<Employee>>{
        return Observer {
            users.postValue(it)
        }
    }

}