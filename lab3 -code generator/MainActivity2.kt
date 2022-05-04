package com.example.aplikacja_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val showText = findViewById<TextView>(R.id.textView2)
        val showText2 = findViewById<TextView>(R.id.textView3)
        val code = getIntent().getStringExtra("code")
        val orginalText = getIntent().getStringExtra("orginalText")
        val shareButton = findViewById<Button>(R.id.share_button)
        val switchButton = findViewById<Switch>(R.id.switch1)
        val backButton = findViewById<Button>(R.id.goBack_button)

        showText.text =
            if(code == null)
                getString(R.string.no_target_selected)
            else getString(R.string.text_code, code)

        showText2.text =
            if(code == null)
                getString(R.string.no_target_selected)
            else getString(R.string.text_orginal, orginalText)


        fun share(switchButton: Boolean){

            var stringToShare = ""
            val intent = Intent().apply{
                action = Intent.ACTION_SEND
                type = "text/plain"
            }

            if(!switchButton){
                intent.putExtra(Intent.EXTRA_TEXT, code)
                startActivity(intent)
            }else{
                stringToShare = "To jest orginał: $orginalText, a to po zakodowanu: $code"
                intent.putExtra(Intent.EXTRA_TEXT, stringToShare)
                startActivity(intent)
            }
        }

        shareButton.setOnClickListener{
            val prawda = switchButton.isChecked()
            share(prawda)
        }

        backButton.setOnClickListener{
            finish()
        }
    }
}
