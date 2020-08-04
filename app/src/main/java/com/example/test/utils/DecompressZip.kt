package com.example.test.utils

import android.util.Log
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.inject.Inject

class DecompressZip @Inject constructor() {

    fun unPackZip(path: String): String {
        val wwis: InputStream
        val zis: ZipInputStream
        var filename = ""
        try {
            wwis = FileInputStream(path)
            zis = ZipInputStream(BufferedInputStream(wwis))
            var ze: ZipEntry
            val buffer = ByteArray(4096)
            var count: Int
            while (zis.nextEntry.also { ze = it } != null) {
                Log.e("name", ze.name)
                filename = ze.name
                // Need to create directories if not exists, or
                // it will generate an Exception...
//                if (ze.isDirectory) {
//                    val fmd = File(path + filename)
//                    fmd.mkdirs()
//                    continue
//                }
                Log.e("path complete", path.substring(0, path.lastIndexOf("/")) + "/"+ filename)
                return readText(path.substring(0, path.lastIndexOf("/")) + "/"+ filename)
//                val fout = FileOutputStream(path.substring(0, path.lastIndexOf("/")) + "/"+ filename)
//                filename = path.substring(0, path.lastIndexOf("/")) + "/"+ filename
//                while (zis.read(buffer).also { count = it } != -1) {
//                    fout.write(buffer, 0, count)
//                }
//                fout.close()
//                zis.closeEntry()
            }
            zis.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return "error"
        }
        return "correct"
    }

     fun readText(filename: String) : String{
        val file = File(filename)
        var data = ""
        val text = StringBuilder()
        try {
            val br = BufferedReader(FileReader(file))
            var line: String?
            while (br.readLine().also { line = it } != null) {
                text.append(line)
                text.append('\n')
            }
            Log.e("texto", text.toString())
            data = text.toString()
            br.close()
        } catch (e: IOException) {
            //You'll need to add proper error handling here
        }
        return data
    }
}