package com.example.apkazajecia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var Anglia = Country("Anglia", "Kraj stanowiący część Zjednoczonego Królestwa Wielkiej Brytanii i Irlandii Północnej.")
    var Niemcy = Country("Niemcy", "Państwo federacyjne położone w zachodniej i środkowej Europie.")
    var Polska = Country("Polska", "Państwo unitarne w Europie Środkowej, położone między Morzem Bałtyckim na północy a Sudetami i Karpatami na południu.")
    var USA = Country("USA", "Państwo federacyjne w Ameryce Północnej składające się z 50 stanów, graniczące z Kanadą")
    var Francja = Country("Francja", "Państwo, którego część metropolitalna znajduje się w Europie Zachodniej, posiadające także zamorskie terytoria na innych kontynentach.")

    val tablica = arrayOf(Anglia, Niemcy, Polska, USA, Francja)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val inputText: EditText = findViewById(R.id.inputText)
            val showText: TextView = findViewById(R.id.displayTe)
            val showDescription: TextView = findViewById(R.id.displayCountry)

            val buttonElement: Button = findViewById(R.id.buttonn)
            buttonElement.setOnClickListener {
                var number = 0
                val name_length = inputText.text.length
                if (name_length < 5 && name_length > 1) {
                    number = 0
                }
                if (name_length < 8 && name_length > 5) {
                    number = 1
                }
                if (name_length < 11 && name_length > 8) {
                    number = 2
                }
                if (name_length < 15 && name_length > 11) {
                    number = 3
                }
                showText.text = tablica[number].nazwa
                showDescription.text = tablica[number].opis
        }
    }
}
