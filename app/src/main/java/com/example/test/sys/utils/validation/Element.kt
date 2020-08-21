package com.example.test.sys.utils.validation

import com.example.test.sys.utils.validation.enums.TypeComponent

class Element(val validationMetrics: Array<ValidationMetrics>,
              val element: Any,
              val typeComponent: TypeComponent
)