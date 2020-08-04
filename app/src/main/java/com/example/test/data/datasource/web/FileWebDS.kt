package com.example.test.data.datasource.web

import android.util.Log
import androidx.lifecycle.Observer
import com.example.test.network.model.Data
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
        decompressZip.readText("/storage/emulated/0/Android/data/com.example.test/files/test4/employees_data.json")
//            FileLoader.with(App.getAppContext())
//                .load(url, false)
//                .fromDirectory("test4", FileLoader.DIR_EXTERNAL_PRIVATE)
//                .asFile(object : FileRequestListener<File> {
//                    override fun onLoad(request: FileLoadRequest, response: FileResponse<File>) {
//                        val loadedFile = response.body
//                        Log.e("path", loadedFile.absolutePath)
//                        Log.e("onLoad", "correct")
//                        val action: Array<String> = decompressZip.unPackZip(loadedFile.absolutePath)
//                        Log.e("size", action.size.toString())
//                        if (action[0] == "correct") {
//                            Log.e("correcto", "Archivo descomprimido correctamente")
//                            Log.e("filename", action[1])
//                            Log.e("file", decompressZip.readText(action[1]))
//                        } else {
//                            Log.e("Algo salio mal", "error")
//                        }
//                    }
//                    override fun onError(request: FileLoadRequest, t: Throwable) {
//                    }
//                })
    }
}