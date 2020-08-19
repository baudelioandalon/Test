package com.example.test.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.test.domain.FileRepository
import com.example.test.domain.MenuRepository
import com.example.test.network.model.Data
import com.example.test.sys.di.component.DaggerComponentDecompressZip
import com.example.test.sys.di.component.DaggerComponentFileRepository
import com.example.test.sys.di.component.DaggerComponentMenuRepository
import com.example.test.utils.DecompressZip
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import java.io.File
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.nio.charset.Charset
import javax.inject.Inject


class MenuViewModel @Inject constructor(): ViewModel(), LifecycleObserver {

    @Inject lateinit var menuRepository: MenuRepository
    @Inject lateinit var fileRespository: FileRepository
    @Inject lateinit var decompressZip: DecompressZip

    val data: MutableLiveData<Data> = MutableLiveData()

    init {
        DaggerComponentMenuRepository.create().inject(this)
        DaggerComponentFileRepository.create().inject(this)
        DaggerComponentDecompressZip.create().inject(this)
    }


    fun onRequestURL(searchString: String){
        //Step 1 -> getContentUrl
        menuRepository.requestDataURLFromNetwork(searchString, observerContentZip())
    }

    private fun getZipFile(url: String){
        //Step 2 -> DownloadZipFile

            fileRespository.requestFileFromNetwork(url, observerFileDownloading())

    }


    private fun observerContentZip() : Observer<Data>{
        return Observer { response ->
            if(response != null){
                data.postValue(response)
                getZipFile(response.data?.file.toString())
            }else{
                data.postValue(null)
            }
        }
    }

    private fun observerFileDownloading() : Observer<Data>{
        return Observer { response ->
            if(response != null){
                data.postValue(response)
                Log.e("ruta", response.data!!.file)
                decompressFile(response.data.file)
//                getZipFile(data.value?.data!!.file)
            }else{
                data.postValue(null)
            }
        }
    }

    private fun decompressFile(path: String){
        var file: File? = null
        viewModelScope.launch {
            supervisorScope {
                val task = async {
                    file = File(decompressZip.unPackZip(path))
                }
                try {
                    Log.e("task", "Ok ${task.await()}")
                } catch (e: Throwable) {
//                    Log.e("task", "Error! ${e.message}")
                }
                val stream = FileInputStream(file)
                var jString: String? = null
                jString = try {
                    val fc: FileChannel = stream.channel
                    val bb: MappedByteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size())
                    Charset.defaultCharset().decode(bb).toString()
                } finally {
                    stream.close()
                }
                Log.e("jstring", jString)
                Log.e("task", "finished")
            }
        }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onDestroy(){
        Log.e("lifecycle", "onCreate")
        onRequestURL("0")
    }

}