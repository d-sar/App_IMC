package com.example.projetimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
   private lateinit var poids : EditText
   private lateinit var taille : EditText
   private lateinit var button: Button
   private lateinit var imageButton: ImageButton
   private lateinit var resultat : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        poids = findViewById(R.id.poids)
        taille = findViewById(R.id.taille)
        button = findViewById(R.id.button)
        imageButton = findViewById(R.id.imageButton)
        resultat = findViewById(R.id.resultat)

        button.setOnClickListener {
            calculeImc()
        }
    }
    private fun calculeImc() {

        val monPoids = poids.text.toString().toDouble()
        val maTaille = taille.text.toString().toDouble()
        val resultatCalcul = monPoids / (maTaille * maTaille)

        resultat.text = "Votre IMC est : %.2f".format(resultatCalcul)

        if (resultatCalcul < 18.5) {
            imageButton.setImageResource(R.drawable.maigre)
        } else if (resultatCalcul >= 18.5 && resultatCalcul < 25) {
            imageButton.setImageResource(R.drawable.normal)
        } else if (resultatCalcul >= 25 && resultatCalcul < 30) {
            imageButton.setImageResource(R.drawable.surpoids)
        } else if (resultatCalcul >= 30 && resultatCalcul < 35) {
            imageButton.setImageResource(R.drawable.obese)
        }else
            imageButton.setImageResource(R.drawable.t_obese)
    }

}