package com.example.meuprimeirapp.AgendaV3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meuprimeirapp.databinding.ActivityTelaInicialV3Binding

class TelaInicialV3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialV3Binding
    private lateinit var adapter: ContatoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialV3Binding.inflate(layoutInflater)

        setTitle("AGENDAV3")

        incializaLista()

        adapter = ContatoAdapter(mutableListOf(), ::onBtEditarClick)
        binding.rvContatos.layoutManager = LinearLayoutManager(this)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        adapter.swapData(AgendaV3.listaContatos)

        setContentView(binding.root)
    }

    private fun incializaLista() {
        AgendaV3.listaContatos.addAll(
            listOf(

                Contato("1 Rodrigo", "1111"),
                Contato("2 Joao", "22222"),
                Contato("3 Maria", "33333"),
                Contato("4 Maria", "33333"),
                Contato("5 Maria", "33333"),
                Contato("6 Maria", "33333"),
                Contato("7 Maria", "33333"),
                Contato("8 Maria", "33333"),
                Contato("9 Maria", "33333"),
                Contato("10 Maria", "33333"),
                Contato("11 Maria", "33333"),
                Contato("12 Maria", "33333"),
                Contato("13 Maria", "33333"),
                Contato("14 Maria", "33333"),
                Contato("15 Maria", "33333"),
                Contato("16 Maria", "33333"),
                Contato("17 Maria", "33333"),
                Contato("19 Maria", "33333"),
                Contato("20 Maria", "33333"),
                Contato("21 Maria", "33333"),
                Contato("22 Maria", "33333"),
                Contato("23 Maria", "33333"),
                Contato("24 Maria", "33333"),
                Contato("25 Maria", "33333"),
                Contato("26 Maria", "33333"),
                Contato("27 Maria", "33333"),

                )
        )
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(this,EditarContatoV3Activity::class.java )
        intent.putExtra("indiceContato", indiceLista)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(AgendaV3.listaContatos)
    }
}