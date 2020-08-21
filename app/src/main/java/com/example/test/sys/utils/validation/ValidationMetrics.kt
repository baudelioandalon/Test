package com.example.test.sys.utils.validation

import android.net.Uri
import com.example.test.sys.utils.validation.enums.TypeActionFromValidation
import com.example.test.sys.utils.validation.enums.TypeValidation

class ValidationMetrics (val validation: TypeValidation,
                         val correct: String?,
                         val incorrect: String?,
                         val whichLimit: Int?,
                         val uriImage: Uri?,
                         val action: TypeActionFromValidation
)