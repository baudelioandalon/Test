package com.example.test.viewmodel

import androidx.lifecycle.*
import com.example.test.R
import com.example.test.domain.DashboardUserRepository
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.component.DaggerComponentDashboardUserRepository
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewColaboradorViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var dashboardUserRepository: DashboardUserRepository

    val topColors: MutableLiveData<ArrayList<Int>> = MutableLiveData(arrayListOf(R.color.white))

    init {
        DaggerComponentDashboardUserRepository.create().inject(this)
    }

    fun sendUsers(users: ArrayList<Employee>, observer: Observer<Task<Void>>){
        viewModelScope.launch {
            dashboardUserRepository.setFirebaseUsers(users, observer)
        }
    }

}