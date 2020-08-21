package com.example.test.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.R
import com.example.test.ui.DashboardFragment
import com.example.test.ui.UsersFragment
import javax.inject.Inject
import kotlin.collections.ArrayList

class InicioViewModel @Inject constructor(): ViewModel(){

    var fragmentsInicio: MutableLiveData<ArrayList<Fragment>> = MutableLiveData(arrayListOf(DashboardFragment(), UsersFragment()))
    var position: MutableLiveData<Int> = MutableLiveData(0)
    val stateMenu: MutableLiveData<Boolean> = MutableLiveData(true)
    val topColors: MutableLiveData<ArrayList<Int>> = MutableLiveData(arrayListOf(R.color.blue_light, R.color.blue_strong, R.color.white))

}