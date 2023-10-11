package com.testApp.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val db = Firebase.firestore
    val dataList = mutableListOf<Map<String, Any>>()
    private lateinit var list: List<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recyclerView=findViewById(R.id.recyclerView)
        db.collection("testData")
            .get()
            .addOnSuccessListener { result ->
                for (document in result ) {
                    val data = document.data
                    dataList.add(data)

                }
            }


    }
}