package com.example.kotlintutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SpinnerActivity : AppCompatActivity() {
    private lateinit var spinner : Spinner
    private lateinit var acAuto : AutoCompleteTextView
    private val languages = arrayOf("Nepali", "English", "Hindi")

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

        spinner = findViewById(R.id.spinner)
        acAuto = findViewById(R.id.acAuto)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, languages)

        spinner.adapter = adapter

        val  acAutoAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, languages)

        acAuto.setAdapter(acAutoAdapter)
        acAuto.threshold = 1

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()

               Toast.makeText(this@SpinnerActivity, "Selected item : $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}