package com.example.di_practica1_playjuegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Busacmos y asignamos el view/componente a un objeto(inferido como button)
        //btnNewPlayer en lugar de jugador, es buena practica?
        val btnNewPlayer = findViewById(R.id.btnNewPlayer) as Button
        //Añadimos listener a ese objeto button y le suministramos la actividad que llevara a cabo
        btnNewPlayer.setOnClickListener { lanzaNewPlayer() }

        val btnPreferences = findViewById<Button>(R.id.btnPreferences)
        btnPreferences.setOnClickListener { lanzaPreferences() }

        //Cambiamos la fuente del titulo
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        tvTitle.typeface = ResourcesCompat.getFont(this, R.font.courgetteregular)

        //Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)




    }

    fun lanzaPreferences(){
        startActivity(Intent(this, Preferences::class.java))
    }

    fun lanzaGeneros(){
        startActivity(Intent(this,Generos::class.java))
    }

    fun lanzaNewPlayer(){
        //val i = Intent(this, NewPlayer::class.java)
        //Buscar Intent, debe ser lanzar la nueva actividad¿
        startActivity(Intent(this, NewPlayer::class.java))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.action_search) -> {
                Toast.makeText(this,"Search",Toast.LENGTH_LONG).show()
                return true
            }
            (R.id.action_add) -> {
                Toast.makeText(this,"Add",Toast.LENGTH_LONG).show()
                return true
            }
            (R.id.action_settings) -> {
                lanzaGeneros()
                return true
            }
            else -> {return super.onOptionsItemSelected(item)}

        }

    }
}
