package com.example.test.data.datasource.web

import androidx.lifecycle.Observer
import com.example.test.network.ApiCallback
import com.example.test.network.BASE_URL
import com.example.test.network.WeatherNetwork
import com.example.test.network.model.Data
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MenuWebDS @Inject constructor(){

    fun requestUserNetwork(searchString: String, observer: Observer<Data>){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(WeatherNetwork::class.java)
        service.getData(searchString).enqueue(ApiCallback<Data>(Observer {
            observer.onChanged(it as Data)
        }))
    }
}