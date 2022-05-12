package com.example.lab3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock.sleep
import android.util.TypedValue
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule
import kotlin.concurrent.timerTask
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getText = findViewById<EditText>(R.id.textInput)
        val text = findViewById<TextView>(R.id.textView)
        val aaa = findViewById<LinearLayout>(R.id.textView4)
        val dodaj = findViewById<Button>(R.id.buttonn)
        val goNext = findViewById<ImageView>(R.id.goNext)

        val textArray = mutableListOf("kanapka", "parowka", "ketchup")

        goNext.setOnClickListener{
            var toShare ="Twoja lista zakupów to: "

            for(x in textArray.indices){
                toShare += textArray[x] + ", "
            }
            val i = Intent(this, MainActivity2::class.java)
            i.putExtra("lista", toShare)
            startActivity(i)
        }

        fun renderList(){
            for (i in textArray.indices) {
                val textView = TextView(this)
                textView.text = textArray[i]
                textView.setOnClickListener{
                    textView.setTextColor(Color.parseColor("#FF0000"))
                    val handler = Handler()
                    handler.postDelayed({
                        textArray.remove(textArray[i])
                        aaa.removeView(textView)
                    }, 2000)
                }
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                aaa.addView(textView)
            }
        }

        aaa.orientation = LinearLayout.VERTICAL
        aaa.removeAllViews()
        renderList()

        dodaj.setOnClickListener{
            val text = getText.text.toString()
            aaa.orientation = LinearLayout.VERTICAL
            textArray.add(text)
            aaa.removeView(aaa)
            aaa.removeAllViews()
            renderList()
            getText.setText("")
        }
    }
}
