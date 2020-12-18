package com.example.kotlintutorials

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnListView: Button
    private lateinit var btnCountries: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnListView = findViewById(R.id.btnListView)
        btnCountries = findViewById(R.id.btnCountries)

        btnCountries.setOnClickListener(this)
        btnListView.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnListView -> {
                //Toast.makeText(this, "List view", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ListViewActivity::class.java)
                startActivity(intent)
            }

            R.id.btnCountries -> {
                val intent = Intent(this, CountriesActivity::class.java)
                startActivity(intent)
            }
            }
        }
    }