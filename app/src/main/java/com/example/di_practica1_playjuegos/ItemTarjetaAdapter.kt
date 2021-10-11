package com.example.di_practica1_playjuegos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemTarjetaAdapter(var items: ArrayList<ItemTarjeta>) : RecyclerView.Adapter<ItemTarjetaAdapter.TarjViewHolder>() {
    lateinit var onClick : (View) -> Unit


    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var texto: TextView

        init {
            texto = itemView.findViewById(R.id.tvGenero)
        }

        fun bindTarjeta(t: ItemTarjeta, onClick: (View) -> Unit) = with(itemView) {
            texto.setText(t.cadena)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_generos, viewGroup, false)
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