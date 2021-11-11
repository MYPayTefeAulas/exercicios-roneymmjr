package com.example.meuprimeirapp.AgendaV4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meuprimeirapp.databinding.ActivityEditarContatoV4Binding
import com.example.meuprimeirapp.databinding.ItemContantoV4Binding

class ContatoAdapter(
    val listaContatos: MutableList<Contato>,
    val onBtEditarClick: (Int) -> Unit
) : RecyclerView.Adapter<ContatoAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemContantoV4Binding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemContantoV4Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun getItemCount(): Int {
        return listaContatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNome.text = listaContatos[position].nome
        holder.binding.txtTelefone.text = listaContatos[position].telefone

//        holder.binding.root.setOnClickListener {
//            onItemClick(position)
//        }

        holder.binding.btEditarContato.setOnClickListener {
            onBtEditarClick(position)
        }
    }

    fun swapData(novaListaContatos: List<Contato>){
        listaContatos.clear()
        listaContatos.addAll(novaListaContatos)
        notifyDataSetChanged()
    }
}