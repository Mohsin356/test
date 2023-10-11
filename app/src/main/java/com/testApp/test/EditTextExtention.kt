package com.testApp.test

import android.widget.EditText
import androidx.core.widget.addTextChangedListener

fun EditText.validate(validationRule: ValidationRule){
    addTextChangedListener {
        val input =it.toString().trim()
        val isValid=input.matches(Regex(validationRule.regex))
        if (isValid){
            println(it.toString())
        }
        else{
            error=validationRule.errorMessage
        }
    }
}

