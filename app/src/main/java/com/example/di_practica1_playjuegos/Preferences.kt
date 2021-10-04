package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_preferences.*

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        var opcionSeleccionada = "No has seleccionado una opcion"
        var puntuacionSeleccion = ""
        var haSeleccionado = false

        val rGroup = findViewById(R.id.radioGroup) as RadioGroup

        rGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val checkedRadioButton = rGroup.findViewById<RadioButton>(checkedId)
                opcionSeleccionada = checkedRadioButton.text as String
                haSeleccionado = true
            }
        })


        val sbPuntuacion = findViewById<SeekBar>(R.id.sbPuntuacion)
        sbPuntuacion.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                rbPuntuacion.rating = progress.toFloat()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar){}

        })

        val rbPuntuacion = findViewById<RatingBar>(R.id.rbPuntuacion)
        rbPuntuacion.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener{ratingBar, rating, fromUser ->
            sbPuntuacion.progress = rating.toInt()
        }

        val fabCheck = findViewById<FloatingActionButton>(R.id.fabPreferencesCheck)
        fabCheck.setOnClickListener{
            puntuacionSeleccion = " Nota: ${rbPuntuacion.rating}"
            if (haSeleccionado)
                Snackbar.make(it, opcionSeleccionada.plus(puntuacionSeleccion), Snackbar.LENGTH_LONG).show()
            else
                Snackbar.make(it, opcionSeleccionada, Snackbar.LENGTH_LONG).show()
        }
    }
}