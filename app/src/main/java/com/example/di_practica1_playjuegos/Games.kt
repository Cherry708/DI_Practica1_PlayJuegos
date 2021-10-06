package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import com.example.di_practica1_playjuegos.databinding.ActivityGamesBinding

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val binding = ActivityGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaCheckBox = listOf(
            binding.cbGame0,
            binding.cbGame1,
            binding.cbGame2,
            binding.cbGame3,
            binding.cbGame4,
            binding.cbGame5,
            binding.cbGame6
        )


        binding.fabSeleccionar.setOnClickListener{
            var mostrarJuegosSeleccionados = ""
            val listaSeleccionados = mutableListOf<CheckBox>()


            for (checkBox in listaCheckBox){
                if (checkBox.isChecked)
                    listaSeleccionados.add(checkBox)
            }

            if (listaSeleccionados.isEmpty())
                mostrarJuegosSeleccionados = "Debes seleccionar un juego."
            else {
                mostrarJuegosSeleccionados = "Selección: "
                for (checkedBox in listaSeleccionados) {
                    //Ultimo|Unico, lleva punto
                    if (listaSeleccionados.indexOf(checkedBox) == listaSeleccionados.size - 1)
                        mostrarJuegosSeleccionados += "${checkedBox.text}."
                    //Penultimo, lleva y
                    else if (listaSeleccionados.indexOf(checkedBox) == listaSeleccionados.size - 2)
                        mostrarJuegosSeleccionados += "${checkedBox.text} y "
                    //Ninguno, lleva coma
                    else mostrarJuegosSeleccionados += "${checkedBox.text}, "
                }
            }


            Toast.makeText(this,mostrarJuegosSeleccionados, Toast.LENGTH_SHORT).show()        }

    }
}