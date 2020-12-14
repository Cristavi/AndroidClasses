package com.example.kotlintutorials

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    private lateinit var btnLoad : Button
    private lateinit var tvCalendar : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)

        btnLoad = findViewById(R.id.btnLoad)
        tvCalendar = findViewById(R.id.tvCalendar)

        btnLoad.setOnClickListener{
            loadCalendar()
        }

    }

    @SuppressLint("SetTextI18n")
    private fun loadCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener{
                view, year, month, dayOfMonth ->
                tvCalendar.text = "Selected date : $dayOfMonth/${month+1}/$year"
            }, year, month, day
        )

        datePickerDialog.show()
    }
}