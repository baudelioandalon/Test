package com.example.test.adapter

import com.example.test.network.model.jsonModel.Employee

interface CustomListeners {
    fun onShow(item: Employee, position: Int)
}