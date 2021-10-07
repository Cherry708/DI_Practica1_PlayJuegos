package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.di_practica1_playjuegos.databinding.ActivityNewPlayerBinding

class NewPlayer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_player)

        val binding = ActivityNewPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaTelefonos = listOf<String>(
            "Telefono 1",
            "Telefono 2",
            "Telefono 3",
            "Telefono 4",
            "Telefono 5"
        )

        /*val adaptador = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, listaTelefonos)
         */

        val spnTelefonos = findViewById<Spinner>(R.id.spnTelefonos)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        etPhone.isEnabled = false

        spnTelefonos.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item, listaTelefonos)

        spnTelefonos.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                /*
                Sintaxis de Java porque las propiedades sinteticas de Kotlin fallan
                al asignar un String y solicita Editable, Editable que tampoco
                puede ser casteado.
                https://stackoverflow.com/questions/57056445/
                what-is-the-difference-between-textview-settextstring-and-textview-text-str
                 */
                etPhone.setText(parent!!.getItemAtPosition(position).toString())
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })

    }
}