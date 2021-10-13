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
        items.add(ItemAbout(R.drawable.image1,R.string.aboutName1,"100"))
        items.add(ItemAbout(R.drawable.image2,R.string.aboutName2,"100"))
        items.add(ItemAbout(R.drawable.image3,R.string.aboutName3,"100"))
        items.add(ItemAbout(R.drawable.image4,R.string.aboutName4,"100"))
        items.add(ItemAbout(R.drawable.image5,R.string.aboutName5,"100"))
        items.add(ItemAbout(R.drawable.image6,R.string.aboutName6,"100"))
        items.add(ItemAbout(R.drawable.image7,R.string.aboutName7,"100"))
        items.add(ItemAbout(R.drawable.image8,R.string.aboutName8,"100"))


        val recView = findViewById<RecyclerView>(R.id.rvAbout)

        recView.setHasFixedSize(true)
        recView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

        val adaptador = ItemAboutAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adaptador.onClick = {
            Toast.makeText(this@About, ""+ resources.getString(items[recView.getChildAdapterPosition(it)].nombre), Toast.LENGTH_LONG).show()
        }

    }
}