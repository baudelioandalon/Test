package com.example.test.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.test.R
import com.example.test.domain.DashboardUserRepository
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.component.DaggerComponentDashboardUserRepository
import com.google.android.gms.tasks.Task
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.max

class NewColaboradorViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    @Inject lateinit var dashboardUserRepository: DashboardUserRepository

    val maxValue: MutableLiveData<Int> = MutableLiveData()
    val topColors: MutableLiveData<ArrayList<Int>> = MutableLiveData(arrayListOf(R.color.white))

    init {
        DaggerComponentDashboardUserRepository.create().inject(this)
    }

    fun sendUsers(users: ArrayList<Employee>){
        viewModelScope.launch {
            dashboardUserRepository.setLocalUsersToSQL(users)
        }
    }

    private fun getMaximumID(){
        viewModelScope.launch {
            dashboardUserRepository.getLocalUsers(usersObserver())
        }
    }

    private fun usersObserver(): Observer<ArrayList<Employee>>{
        return Observer {
            maxValue.postValue(it.maxBy { element ->
                element.id.toInt()
            }!!.id.toInt() + 1)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.e("lifecycle", "onCreate")
        getMaximumID()
    }

}