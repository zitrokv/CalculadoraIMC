package com.example.calculadoraimc


import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

//import java.util.Random



class MainActivity : AppCompatActivity() {

    lateinit var welcomeTextView : TextView
    lateinit var clickButton: Button
    var vez = 1
    var random = Random()//.nextInt(0xff, 0xffffff)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.welcomeTextView)
        clickButton = findViewById(R.id.clickButton)


        welcomeTextView.text = "Bienvenidos a la primera aplicacion Android"

        clickButton.setOnClickListener {
            welcomeTextView.text = "He hecho click ${vez++} veces en el botón"
            it.setBackgroundColor(Color.CYAN)
            it.setBackgroundColor(Color.BLUE)
            //val colorAleatorio: Int =  123 //random

            //var intColor = (Random(colorAleatorio.rangeUntil().nextInt(2..4))
            //it.setBackgroundColor(getColor(colorAleatorio))
        }



    }
}