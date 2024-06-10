package com.example.a10june

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.max


private val dates = ArrayList<String>()
private val mintemp = ArrayList<Int>()
private val maxtemp = ArrayList<Int>()
private val conditionweather = ArrayList<String>()
private fun EditText.isNotEmpty() {return}

class Main : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val date = findViewById<EditText>(R.id.date)
        val minWeather = findViewById<EditText>(R.id.min)
        val maxWeather = findViewById<EditText>(R.id.max)
        val conditionweather = findViewById<EditText>(R.id.notes)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clear)
        val detailsbutton = findViewById<Button>(R.id.detailsbutton)



        addButton.setOnClickListener {
            val date = date.text.toString()
            val minweather = minWeather.text.toString()
            val  maxweather = maxWeather.text.toString()
            val conditionweather = conditionweather.text.toString()

        }



        if (date.isNotEmpty() || minWeather != null || maxWeather != null || conditionweather.isNotEmpty()) {
            dates.(date)
            minWeather.add(minWeather)
            maxWeather.add(maxWeather)
            conditionweather.add(conditionweather)
            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
            clearFields(date, minWeather, maxWeather, conditionweather)
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
        }
    }


    clearButton.setOnClickListener {

        clearFields(dates, mintemp, maxtemp, conditionweather)

    }


    detailsbutton.setOnClickListener {
        val intent = Intent(this, detailed::class.java)
        intent.putStringArrayListExtra("dates", dates)
        intent.putIntegerArrayListExtra("minimum temperature", mintemp)
        intent.putIntegerArrayListExtra("maximum temperature", maxtemp)
        intent.putStringArrayListExtra("conditionWeather", conditionweather)
        startActivity(intent)
    }


private fun clearFields(vararg fields: EditText) {
    for (field in fields) {
        field.text.clear()
    }
}
}





