package com.example.test.adapter

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test.network.model.jsonModel.Employee

abstract class BaseViewHolder: RecyclerView.ViewHolder {

    private var context: Context
    private var customListeners: CustomListeners
    private var id : Int? = null
    constructor(context: Context, customListener: CustomListeners, view: View) : super(view){
        this.context = context
        this.customListeners = customListener
    }

    fun getListener(): CustomListeners{
        return customListeners
    }

    abstract fun bindDataToViewHolder(item: Employee, position: Int)
}