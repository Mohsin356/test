package com.testApp.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.testApp.test.validate

class MainActivity : AppCompatActivity() {
    private lateinit var  editTextEmail:EditText
    private lateinit var editTextNumber:EditText
    private lateinit var editTextPhoneNumber:EditText
    private lateinit var editTextText:EditText
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextEmail= findViewById(R.id.email)
        editTextNumber = findViewById(R.id.number)
        editTextPhoneNumber = findViewById(R.id.phone)
        editTextText = findViewById(R.id.text)
        val button:Button=findViewById(R.id.submitBtn)

        editTextEmail.validate(ValidationRule.EMAIL)
        editTextNumber.validate(ValidationRule.NUMBER)
        editTextText.validate(ValidationRule.TEXT)
        editTextPhoneNumber.validate(ValidationRule.PHONENUMBER)

        button.setOnClickListener {
                   val user= hashMapOf(
                       "email" to editTextEmail.toString(),
                       "number" to editTextNumber.toString(),
                       "phone" to editTextPhoneNumber.toString(),
                       "text" to editTextText.toString(),
                       )
//            val user=User(editTextEmail.toString(),editTextNumber.toString(),editTextPhoneNumber.toString(),editTextText.toString())
        db.collection("testData").add(user)
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)

        }


    }



}