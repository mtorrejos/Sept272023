package com.example.sept272023

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val textName = findViewById<TextView>(R.id.textName)
        val textSection = findViewById<TextView>(R.id.textSection)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        val intent = intent

        textName.setText(intent.getStringExtra("name"))
        textSection.setText(intent.getStringExtra("section"))

        btnLogout.setOnClickListener {
            val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }

    }

}