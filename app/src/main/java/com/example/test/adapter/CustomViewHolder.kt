package com.example.test.adapter

import android.content.Context
import com.example.test.databinding.CustomBinder
import com.example.test.network.model.jsonModel.Employee


class CustomViewHolder : BaseViewHolder{
    private var customBinder: CustomBinder

    constructor(context: Context, customListeners: CustomListeners, customBinder: CustomBinder) : super(context, customListeners, customBinder.root){
        this.customBinder = customBinder
    }

    override fun bindDataToViewHolder(item: Employee, position: Int) {
        customBinder.btn.setOnClickListener {
            getListener().onShow(item, position)
        }
    }

}