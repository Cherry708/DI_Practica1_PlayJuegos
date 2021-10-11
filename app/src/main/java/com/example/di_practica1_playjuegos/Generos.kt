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
        val items = ArrayList<ItemTarjeta>()
        items.add(ItemTarjeta(R.string.note1))
        items.add(ItemTarjeta(R.string.note2))
        items.add(ItemTarjeta(R.string.note3))
        items.add(ItemTarjeta(R.string.note4))
        items.add(ItemTarjeta(R.string.note5))
        items.add(ItemTarjeta(R.string.note6))

        val recView = findViewById<RecyclerView>(R.id.rvListaGeneros)

        recView.setHasFixedSize(true)

        val adaptador = ItemTarjetaAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adaptador.onClick = {
            Toast.makeText(this@Generos, ""+ resources.getString(items[recView.getChildAdapterPosition(it)].cadena), Toast.LENGTH_LONG).show()
        }
        /*
        Clases: Tarjeta, TarjetaAdapter
        Layouts: View RecycleView en activity_genero y item_genero
         */
        //fin recyclerView
    }
}