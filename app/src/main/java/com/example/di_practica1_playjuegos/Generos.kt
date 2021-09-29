package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class Generos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generos)

        //Que es it?
        //Floating action button de ventana generos
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            Snackbar.make(it,"Desplazamiento del boton", Snackbar.LENGTH_LONG).show()
        }
    }
}