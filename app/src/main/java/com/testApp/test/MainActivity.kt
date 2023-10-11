package com.testApp.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.testApp.test.validate

class MainActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout;

    //    private lateinit var  editTextEmail:EditText
//    private lateinit var editTextNumber:EditText
//    private lateinit var editTextPhoneNumber:EditText
//    private lateinit var editTextText:EditText
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.container)
        addEditText("Email", ValidationRule.EMAIL)
        addEditText("Number", ValidationRule.NUMBER)
        addEditText("Phone", ValidationRule.PHONENUMBER)
        addEditText("Text", ValidationRule.TEXT)

        val button: Button = findViewById(R.id.submitBtn)
        val email = (container.getChildAt(0) as EditText).text.toString()
        val number = (container.getChildAt(1) as EditText).text.toString()
        val phone = (container.getChildAt(2) as EditText).text.toString()
        val text = (container.getChildAt(3) as EditText).text.toString()

        button.setOnClickListener {
            val user = hashMapOf(
                "email" to email,
                "number" to number,
                "phone" to phone,
                "text" to text,
            )
//            val user=User(editTextEmail.toString(),editTextNumber.toString(),editTextPhoneNumber.toString(),editTextText.toString())
            db.collection("testData").add(user)
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)


        }


    }

    fun addEditText(hintText: String, validationType: ValidationRule) {
        val editText = EditText(this)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        )


        layoutParams.setMargins(0, 16, 0, 0)



        editText.hint = hintText
        editText.textSize = 16F
        editText.validate(validationType)
        editText.layoutParams = layoutParams
        editText.setBackgroundResource(R.drawable.bg_edit_text)
        container.addView(editText)
    }


}