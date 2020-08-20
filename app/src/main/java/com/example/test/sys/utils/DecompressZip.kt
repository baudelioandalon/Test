package com.example.test.sys.utils

import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import javax.inject.Inject

class DecompressZip @Inject constructor() {

    fun unPackZip(path: String): String {
        val isdd: InputStream
        val zis: ZipInputStream
        var filename: String
        try {
            isdd = FileInputStream(path)
            zis = ZipInputStream(BufferedInputStream(isdd))
            var ze: ZipEntry
            val buffer = ByteArray(4096)
            var count: Int
            while (zis.nextEntry.also { ze = it } != null) {
                filename = ze.name
                if (ze.isDirectory) {
                    val fmd = File(path + filename)
                    fmd.mkdirs()
                    continue
                }
                val fout = FileOutputStream(path.substringBeforeLast('/') + "/" + filename)
                while (zis.read(buffer).also { count = it } != -1) {
                    fout.write(buffer, 0, count)
                }
                fout.close()
                zis.closeEntry()
                return path.substringBeforeLast('/') + "/" + filename
            }
            zis.close()
        } catch (e: IOException) {
            e.printStackTrace()
            return "false"
        }
        return "true"
    }

}