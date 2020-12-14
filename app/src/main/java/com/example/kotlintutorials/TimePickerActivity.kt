package com.example.kotlintutorials

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.TimePicker
import java.util.*

class TimePickerActivity : AppCompatActivity() {
    private lateinit var btnTime : Button
    private lateinit var tvTime : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_picker)

        btnTime = findViewById(R.id.btnTime)
        tvTime = findViewById(R.id.tvTime)

        btnTime.setOnClickListener{
            val c = Calendar.getInstance()
            val hr = c.get(Calendar.HOUR_OF_DAY)
            val min = c.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(
                this, TimePickerDialog.OnTimeSetListener{ _: TimePicker?, hourOfDay: Int, minute: Int ->

                    if (hourOfDay in 0..12) {
                        tvTime.text = "$hourOfDay : $minute am"
                    }
                    if (hourOfDay in 13..23) {
                        tvTime.text = "${hourOfDay-12} : $minute pm"
                    }
                },
                hr, min, true
            )
            timePickerDialog.show()
        }
    }
}