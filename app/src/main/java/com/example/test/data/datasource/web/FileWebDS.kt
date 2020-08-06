package com.example.test.data.datasource.web

import android.util.Log
import androidx.lifecycle.Observer
import com.example.test.network.model.Data
import com.example.test.network.model.DataX
import com.example.test.sys.di.App
import com.example.test.sys.di.component.DaggerComponentDecompressZip
import com.example.test.utils.DecompressZip
import com.krishna.fileloader.FileLoader
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import java.io.File
import javax.inject.Inject

class FileWebDS @Inject constructor(){

    @Inject lateinit var decompressZip: DecompressZip

    init {
        DaggerComponentDecompressZip.create().inject(this)
    }

    fun requestFileFromNetwork(url: String, observer: Observer<Data>){
//        decompressZip.readText("/storage/emulated/0/Android/data/com.example.test/files/test4/employees_data.json")
            FileLoader.with(App.getAppContext())
                .load(url, false)
                .fromDirectory("test4", FileLoader.DIR_EXTERNAL_PRIVATE)
                .asFile(object : FileRequestListener<File> {
                    override fun onLoad(request: FileLoadRequest, response: FileResponse<File>) {
                        val loadedFile = response.body
                        Log.e("path", loadedFile.absolutePath)
                        Log.e("onLoad", "correct")
                        val valorcito = decompressZip.unPackZip(loadedFile.absolutePath)
                        observer.onChanged(Data(response.code, DataX(valorcito),true,null))
                    }
                    override fun onError(request: FileLoadRequest, t: Throwable) {
                        observer.onChanged(Data(400, null,false,t))
                    }
                })
    }
}