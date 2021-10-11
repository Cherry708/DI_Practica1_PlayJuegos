package com.example.di_practica1_playjuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAboutAdapter(var items: ArrayList<ItemAbout>) : RecyclerView.Adapter<ItemAboutAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var nombre: TextView
        private var puntuacion: TextView
        private var imagen: ImageView

        init {
            nombre = itemView.findViewById(R.id.tvNombreAbout)
            puntuacion = itemView.findViewById(R.id.tvPuntuacion)
            imagen = itemView.findViewById(R.id.ivImagen)
        }

        fun bindTarjeta(t: ItemAbout, onClick: (View) -> Unit) = with(itemView) {
            nombre.setText(t.nombre)
            puntuacion.setText(t.puntuacion)
            imagen.setImageResource(t.imagen)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_about, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items.get(pos)
        viewHolder.bindTarjeta(item, onClick)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}