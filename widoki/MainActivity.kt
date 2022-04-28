package com.example.aplikacja_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getText = findViewById<EditText>(R.id.textInput)
        val confirmButton = findViewById<Button>(R.id.buttonMain)
        val showText = findViewById<TextView>(R.id.textViewTop)

        confirmButton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            val text = getText.text.toString()
            intent.putExtra(MainActivity2.REQUEST_TARGET, text)
            startActivity(intent)
        }
    }
}
