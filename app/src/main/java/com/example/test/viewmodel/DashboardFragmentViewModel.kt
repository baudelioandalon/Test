package com.example.test.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.network.model.jsonModel.UserModel
import javax.inject.Inject

class DashboardFragmentViewModel @Inject constructor() : ViewModel(){

    val users: MutableLiveData<ArrayList<UserModel>> = MutableLiveData()

}