package com.example.test.sys.utils

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.example.test.R
import com.example.test.sys.utils.menusliding.SimpleItem
import javax.inject.Inject

class MethodMenu @Inject constructor() {

    fun createItemFor(position: Int, screenTitles: Array<String>, screenIcons: Array<Drawable?>, activity: Activity): SimpleItem {
        return SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.design_default_color_primary_dark, activity))
                .withTextTint(color(R.color.design_default_color_primary, activity))
                .withSelectedIconTint(color(R.color.design_default_color_secondary, activity))
                .withSelectedTextTint(color(R.color.design_default_color_secondary, activity))
    }

    @ColorInt
    private fun color(@ColorRes res: Int, activity: Activity): Int {
        return ContextCompat.getColor(activity, res)
    }
}