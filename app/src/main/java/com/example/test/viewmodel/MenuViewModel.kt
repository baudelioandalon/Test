package com.example.test.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.test.domain.FileRepository
import com.example.test.domain.MenuRepository
import com.example.test.network.model.Data
import com.example.test.sys.di.component.DaggerComponentFileRepository
import com.example.test.sys.di.component.DaggerComponentMenuRepository
import javax.inject.Inject

class MenuViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    @Inject lateinit var menuRepository: MenuRepository
    @Inject lateinit var fileRespository: FileRepository

    val data: MutableLiveData<Data> = MutableLiveData()

    init {
        DaggerComponentMenuRepository.create().inject(this)
        DaggerComponentFileRepository.create().inject(this)
    }


    private fun onRequestURL(searchString: String){
        menuRepository.requestDataURLFromNetwork(searchString, observerContentZip())
    }

    private fun getZipFile(url: String){
        fileRespository.requestFileFromNetwork(url,observerFileDownloading() )
    }

    private fun observerContentZip() : Observer<Data>{
        return Observer {response ->
            if(response != null){
                data.postValue(response)
                getZipFile(response.data?.file.toString())
            }else{
                data.postValue(null)
            }
        }
    }

    private fun observerFileDownloading() : Observer<Data>{
        return Observer {response ->
            if(response != null){
                data.postValue(response)
                getZipFile(data.value?.data!!.file)
            }else{
                data.postValue(null)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(){
        Log.e("lifecycle","onCreate")
        onRequestURL("0")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        Log.e("lifecycle","onDestroy")
    }

}
