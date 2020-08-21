package com.example.test.sys.utils

import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.RequiresApi
import com.example.test.R
import com.example.test.sys.di.App
import javax.inject.Inject

class TextChanged @Inject constructor() {

    fun tWatcher(editText: EditText): TextWatcher{
        return object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                editText.background = App.getAppContext().getDrawable(R.drawable.simple_with_border_gray)
            }
        }
    }

}