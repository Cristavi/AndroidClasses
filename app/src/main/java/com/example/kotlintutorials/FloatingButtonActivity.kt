package com.example.kotlintutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FloatingButtonActivity : AppCompatActivity() {
    private lateinit var et1 : EditText
    private lateinit var et2 : EditText
    private lateinit var floatingBtn : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating_button)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        floatingBtn = findViewById(R.id.floatingBtn)

        floatingBtn.setOnClickListener{
            Toast.makeText(this@FloatingButtonActivity, "The sum is " +
                    "${et1.text.toString().toInt() + et2.text.toString().toInt()}",
                Toast.LENGTH_SHORT).show()
        }


    }
}