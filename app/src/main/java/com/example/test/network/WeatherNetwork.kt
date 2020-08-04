package com.example.test.network

import com.example.test.network.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://dl.dropboxusercontent.com/"
//EXAMPLE https://dl.dropboxusercontent.com/s/5u21281sca8gj94/getFile.json?dl=0 ”.
interface WeatherNetwork {

    @GET("s/5u21281sca8gj94/getFile.json?")
    fun getData(@Query("dl")searchData : String) : Call<Data>
}