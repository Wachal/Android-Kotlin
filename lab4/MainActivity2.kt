package com.example.lab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import com.example.lab3.R

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val list = getIntent().getStringExtra("lista")
        val textView = findViewById<TextView>(R.id.textView2)
        val arrow = findViewById<ImageView>(R.id.arrow)

        textView.text = list

        arrow.setOnClickListener{
            finish()
        }
    }
}
