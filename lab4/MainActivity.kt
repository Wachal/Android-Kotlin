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

        val viewEl = findViewById<LinearLayout>(R.id.textView4)

        val persons = arrayOf(
            Person("Nenya", "also named as the Ring of Water, the White Ring and the Ring of Adamant", "The ring was wielded by Galadriel of Lothlórien, and possesses radiance that matches that of the stars"),
            Person("Vilya", "the Ring of Air, Blue Ring, the Dominant Ring, or Ring of Sapphire ", "Upon the One Ring's destruction, the power of Vilya faded, and it was taken over the sea by Elrond at the end of the Third Age."),
            Person("Narya", "also named the Ring of Fire or Red Ring", "Narya was worn openly by Gandalf at his departure from the Grey Havens."),
            )

        fun renderList(){
            for (i in persons.indices) {
                val textView = TextView(this)
                val person = persons[i].personName()
                val description = persons[i].returnDesription()
                textView.text = person
                textView.setOnClickListener{
                    val i = Intent(this, MainActivity2::class.java)
                    i.putExtra("lista", description)
                    startActivity(i)
                }

                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                viewEl.addView(textView)
            }
        }

        viewEl.orientation = LinearLayout.VERTICAL
        viewEl.removeAllViews()
        renderList()

    }
}
