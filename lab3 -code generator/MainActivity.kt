package com.example.aplikacja_lab2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getText = findViewById<EditText>(R.id.textInput)
        val confirmButton = findViewById<Button>(R.id.buttonMain)
        val codeCategory  = findViewById<Spinner>(R.id.spinner)

            confirmButton.setOnClickListener{
                val text = getText.text.toString()
                val codeChoice = codeCategory.selectedItem.toString()

                var genCode = CodeGenerator(codeChoice, text)
                var code = genCode.result.toString()

                val i = Intent(this, MainActivity2::class.java)
                i.putExtra("code", code)
                i.putExtra("orginalText", text)
                startActivity(i)
        }
    }
}
