package com.testApp.test

enum class ValidationRule(val regex: String, val errorMessage: String) {
    EMAIL("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+", "Please enter a valid email address"),
    NUMBER("^[0-9]", "Please enter a single number value"),
    PHONENUMBER("^[0-9]{11}$", "Please enter 11 characters only"),
    TEXT("[^\\n]+", "Please enter alpha-numeric values")
}