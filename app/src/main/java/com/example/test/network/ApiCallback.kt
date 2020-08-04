package com.example.test.network

import androidx.lifecycle.Observer
import com.example.test.network.model.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCallback<T : Data>(private val observer: Observer<Any?>) :
    Callback<T> {
    override fun onResponse(
        call: Call<T>,
        response: Response<T>) {
        if(response.isSuccessful && response.body()?.code == 200){
            observer.onChanged(response.body())
        }else{
            val data = Data(response.code(), response.body()?.data, false, null)
            observer.onChanged(data)
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        val data = Data(400, null, false, t)
        observer.onChanged(data)
    }

}