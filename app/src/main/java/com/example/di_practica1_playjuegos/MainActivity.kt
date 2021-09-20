package com.example.di_practica1_playjuegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Busacmos y asignamos el view/componente a un objeto(inferido como button)
        //btnNewPlayer en lugar de jugador, es buena practica?
        val btnNewPlayer = findViewById(R.id.btnNewPlayer) as Button
        //Añadimos listener a ese objeto button y le suministramos la actividad que llevara a cabo
        btnNewPlayer.setOnClickListener { lanzaNewPlayer() }
    }
    fun lanzaNewPlayer(){
        //val i = Intent(this, NewPlayer::class.java)
        //Buscar Intent, debe ser lanzar la nueva actividad¿
        startActivity(Intent(this, NewPlayer::class.java))
    }
}
