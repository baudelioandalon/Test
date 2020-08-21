package com.example.test.sys.utils.menusliding

import android.app.Activity
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import javax.inject.Inject

class StatusBarChangeColor @Inject constructor() {

    @RequiresApi(Build.VERSION_CODES.M)
    fun changeColor(activity: Activity, state: Boolean?, position: Int?, slidingStatus: SlidingStatus?, colors: ArrayList<Int>?, actividad: String?){
        when(actividad){
            "InicioActivity" -> {
                when(slidingStatus){
                    SlidingStatus.STARTING -> {
                        when(state){
                            true -> {
                                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                                activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![colors.size - 1])
                            }
                            else -> activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![position!!])
                        }
                    }
                    SlidingStatus.CLOSED -> {
                        activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![position!!])
                    }
                    SlidingStatus.OPENED -> {
                        activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![colors.size - 1])
                        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                    }
                }
            }
            "LoginActivity" -> {
                when(slidingStatus){
                    SlidingStatus.STARTING -> {activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![0])
                        activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR}
                    else -> activity.window.statusBarColor = ContextCompat.getColor(activity, colors!![0])
                }
            }
        }

    }
}