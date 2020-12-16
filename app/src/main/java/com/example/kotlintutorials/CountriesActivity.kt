package com.example.kotlintutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class CountriesActivity : AppCompatActivity() {
    private val countries = arrayOf("Nepal", "Kathmandu",
        "India", "New Delhi",
        "China", "Beijing")
    private lateinit var listView : ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        listView = findViewById(R.id.listView)

        val capital = mutableMapOf<String, String>()

        for (i in countries.indices step 2){
            capital[countries[i]] = countries[i + 1]
        }

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            capital.keys.toTypedArray())

        listView.adapter = adapter

        listView.setOnItemClickListener{
                parent, view, position, id ->
            val element = parent.getItemAtPosition(position).toString()
            val capital = capital[element]!!.toString()
            //Toast.makeText(this, "The capital is $capital", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CapitalActivity::class.java)
            intent.putExtra("country", element)
            intent.putExtra("capital", capital)
            startActivity(intent)
        }
    }
}