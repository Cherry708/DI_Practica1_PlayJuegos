package com.example.di_practica1_playjuegos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.marginBottom
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_preferences.*

class Preferences : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        var option = ""

        val rGroup = findViewById(R.id.radioGroup) as RadioGroup

        rGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                val checkedRadioButton = rGroup.findViewById<RadioButton>(checkedId)
                option = checkedRadioButton.text as String
            }
        })

        val fabCheck = findViewById<FloatingActionButton>(R.id.fabPreferencesCheck)
        fabCheck.setOnClickListener{
            if (option.isNotEmpty())
                Snackbar.make(it, option, Snackbar.LENGTH_LONG).show()
        }
    }
}