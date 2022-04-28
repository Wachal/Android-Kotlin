package com.example.aplikacja_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    companion object{
        const val REQUEST_TARGET = "requestTarget"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text = intent.getStringExtra(REQUEST_TARGET)
        val showText = findViewById<TextView>(R.id.textView2)

        showText.text =
            if(text == null)
                getString(R.string.no_target_selected)
            else getString(R.string.text_responsee, text)

    }
}
