package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val items = ArrayList<ItemAbout>()
        items.add(ItemAbout(R.drawable.image1,"Nombre","100"))
        items.add(ItemAbout(R.drawable.image2,"Nombre","100"))
        items.add(ItemAbout(R.drawable.image3,"Nombre","100"))

        val recView = findViewById<RecyclerView>(R.id.rvAbout)

        recView.setHasFixedSize(true)
        recView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val adaptador = ItemAboutAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adaptador.onClick = {
            Toast.makeText(this@About, ""+ items[recView.getChildAdapterPosition(it)], Toast.LENGTH_LONG).show()
        }

    }
}