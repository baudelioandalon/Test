package com.example.test.sys.utils

import android.graphics.Color
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import javax.inject.Inject

class ColorMarker @Inject constructor(){
    val markerIcon: BitmapDescriptor
        get() {
            val hsv = FloatArray(3)
            Color.colorToHSV(Color.parseColor(hexColor()), hsv)
            return BitmapDescriptorFactory.defaultMarker(hsv[0])
        }

    private fun hexColor(): String {
        val red = (Math.random() * 256).toInt()
        val green = (Math.random() * 256).toInt()
        val blue = (Math.random() * 256).toInt()
        val randomColor = Color.rgb(red, green, blue)
        return String.format("#%06X", 0xFFFFFF and randomColor)
    }
}