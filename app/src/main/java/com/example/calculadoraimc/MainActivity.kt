package com.example.calculadoraimc


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.os.Bundle
import android.widget.*
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
    lateinit var imagenImgView: ImageView
    //var imagenImgView = findViewById<ImageView>(R.id.imagenImgView)



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

        imagenImgView = findViewById<ImageView>(R.id.imagenImgView)

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

            val bitmap = BitmapFactory.decodeResource(resources, R.id.imagenImgView)

            val anchuraImg = bitmap.width / 4 // Asume que la imagen tiene 4 figuras de igual tamaño

            val rect: Rect = when (datoPeso / (datoAltura/100f).pow(2)) {
                in (0f..18.5f)  -> Rect(0, 0, anchuraImg, bitmap.height)
                in (18.5..24.9) -> Rect(anchuraImg, 0, 2 * anchuraImg, bitmap.height)
                in (25.0..29.9) -> Rect(2 * anchuraImg, 0, 3 * anchuraImg, bitmap.height)
                else -> Rect(3 * anchuraImg, 0, 4 * anchuraImg, bitmap.height)
            }

             //val rect: Rect = Rect(0,0, bitmap.width, bitmap.height)

            val croppedBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height())
            imagenImgView.setImageBitmap(croppedBitmap)

        }



    }

   /* fun imagenIMC(datoIMC :Float){
        var img = R.drawable.img

        img

        when( datoIMC) {
            in (0f..18.5f) -> "Bajo"
            in (18.5f..24.9f) -> "Normal"
            in (25f..29.9f) -> "Sobrepeso"
            in (29.9f..800f) -> "Obeso"
            else -> "datos incorrectos"
        }
    }*/
    fun resfrescaAltura(){
        alturaEditText.setText(datoAltura.toString())
    }

    fun resfrescaPeso(){
        pesoTextView.setText("$datoPeso Kg")
    }


}