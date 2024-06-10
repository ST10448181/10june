package com.example.a10june

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detailed : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val dates = intent.getStringArrayListExtra("dates") ?: arrayListOf()
        val min = intent.getIntegerArrayListExtra("minimumtemp") ?: arrayListOf()
        val max = intent.getIntegerArrayListExtra("maximumtemp") ?: arrayListOf()
        val conditionweather = intent.getStringArrayListExtra("activityNotes") ?: arrayListOf()

        val viewdetails = findViewById<TextView>(R.id.detailsbutton)
        val cal = findViewById<TextView>(R.id.cal)
        val back = findViewById<Button>(R.id.back)

        var totaltemp = 0
        var displayText = ""
        for (i in dates.indices) {
            val dailyScreenTime = min[i] + max[i]
            totaltemp += dailyScreenTime
            displayText += "Date: ${dates[i]}, Morning: ${min[i]} min, Afternoon: ${max[i]} min, Notes: ${conditionweather[i]}\n\n"
        }
        val averageScreenTime = if (dates.isNotEmpty()) totaltemp / dates.size else 0

        viewdetails.text = displayText
        cal.text = "Average Screen Time: $averageScreenTime minutes/day"

        back.setOnClickListener {
            val intent = Intent(this, Main ::class.java)
            startActivity(intent)

        }
    }
}

