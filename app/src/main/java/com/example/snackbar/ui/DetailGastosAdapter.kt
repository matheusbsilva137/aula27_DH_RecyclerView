package com.example.snackbar.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snackbar.R
import com.example.snackbar.domain.Gasto

class DetailGastosAdapter (private val listGastos: List<Gasto>): RecyclerView.Adapter<DetailGastosAdapter.DetailGastosViewHolder>() {

    class DetailGastosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tv_descricao : TextView = itemView.findViewById(R.id.txv_descricao)
        val tv_categoria : TextView = itemView.findViewById(R.id.txv_categoria)
        val tv_dataHora : TextView = itemView.findViewById(R.id.txv_dataHora)
        val tv_valor : TextView = itemView.findViewById(R.id.txv_valor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailGastosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_gasto, parent, false)
        return DetailGastosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DetailGastosViewHolder, position: Int) {
        val currentItem = listGastos[position]
        holder.tv_descricao.setText(currentItem.descricao)
        holder.tv_categoria.setText(currentItem.categoria)
        holder.tv_dataHora.setText(currentItem.dataHora)
        holder.tv_valor.setText(currentItem.valor.toString())
    }

    override fun getItemCount(): Int {
        return listGastos.size
    }
}