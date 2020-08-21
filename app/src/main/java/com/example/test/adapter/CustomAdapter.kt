package com.example.test.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.test.R
import com.example.test.databinding.CustomBinder
import com.example.test.network.model.jsonModel.Employee
import com.example.test.sys.di.App

class CustomAdapter( private var customListeners: CustomListeners)
    : ListAdapter<Employee, CustomViewHolder>(CarDiffUtil()) {
    private lateinit var customBinder: CustomBinder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        customBinder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_item, parent, false)
        return CustomViewHolder(App.getAppContext(), customListeners, customBinder)
    }
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        customBinder.model = getItem(position)
        holder.bindDataToViewHolder(getItem(position), position)
    }

}

class CarDiffUtil : DiffUtil.ItemCallback<Employee>(){
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id === newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem == newItem
    }
}