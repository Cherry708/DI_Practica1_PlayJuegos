package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        //Tema 3, 1.3 Inicio elementos recyclerView
        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta("Rol"))
        items.add(Tarjeta("Accion"))
        items.add(Tarjeta("Aventura"))
        items.add(Tarjeta("Terror"))
        items.add(Tarjeta("Deportes"))
        items.add(Tarjeta("Estrategia"))

        val recView = findViewById<RecyclerView>(R.id.rvListaGeneros)

        recView.setHasFixedSize(true)

        val adaptador = TarjetaAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adaptador.onClick = {
            Toast.makeText(this@Generos, ""+ items[recView.getChildAdapterPosition(it)].cadena, Toast.LENGTH_LONG).show()
        }
        /*
        Clases: Tarjeta, TarjetaAdapter
        Layouts: View RecycleView en activity_genero y item_genero
         */
        //fin recyclerView
    }
}