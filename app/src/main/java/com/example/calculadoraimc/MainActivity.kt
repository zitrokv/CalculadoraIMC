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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}