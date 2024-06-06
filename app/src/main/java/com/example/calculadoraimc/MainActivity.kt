package com.example.calculadoraimc


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow




class MainActivity : AppCompatActivity() {

    lateinit var alturaEditText : EditText
    lateinit var pesoTextView: TextView
    lateinit var resDesTextView: TextView
    lateinit var resNumTextView: TextView

    lateinit var menosButton :Button
    lateinit var masButton :Button
    lateinit var calcularButton :Button
    var vez = 1
    var datoPeso = 80
    var datoAltura = 160


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alturaEditText = findViewById(R.id.alturaEditText)
        pesoTextView = findViewById(R.id.pesoTextView)
        resDesTextView = findViewById(R.id.resDesTextView)
        resNumTextView = findViewById(R.id.resNumTextView)

        menosButton = findViewById(R.id.menosButton)
        masButton = findViewById(R.id.masButton)
        calcularButton = findViewById(R.id.CalcularButton)


        resfrescaAltura()
        resfrescaPeso()


        menosButton.setOnClickListener {
            datoPeso--
            resfrescaPeso()

        }

        masButton.setOnClickListener {
            datoPeso++
            resfrescaPeso()
        }

        calcularButton.setOnClickListener{
            datoAltura = alturaEditText.text.toString().toInt()
            resNumTextView.text = ( datoPeso / (datoAltura/100f).pow(2)).toString()

            resDesTextView.text =
                when( datoPeso / (datoAltura/100f).pow(2)) {
                    in (0f..18.5f) -> "Bajo"
                    in (18.5f..24.9f) -> "Normal"
                    in (25f..29.9f) -> "Sobrepeso"
                    in (29.9f..800f) -> "Obeso"
                    else -> "datos incorrectos"
                }




        }



    }


    fun resfrescaAltura(){
        alturaEditText.setText(datoAltura.toString())
    }

    fun resfrescaPeso(){
        pesoTextView.setText("$datoPeso Kg")
    }


}