package com.example.meuprimeirapp.Agendav2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meuprimeirapp.Agendav2.AgendaV2
import com.example.meuprimeirapp.Agendav2.ContatoV2
import com.example.meuprimeirapp.Agendav2.ContatosAdapter
import com.example.meuprimeirapp.databinding.ActivityTelaInicialV2Binding

class TelaInicialV2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialV2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialV2Binding.inflate(layoutInflater)

        setTitle("Agendav2")

        incializaLista()
        binding.lvContatos.layoutManager = LinearLayoutManager(this)
        binding.lvContatos.adapter = ContatosAdapter(AgendaV2.listaContatos)
        binding.lvContatos.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        setContentView(binding.root)
    }

    private fun incializaLista() {
        AgendaV2.listaContatos.addAll(
            listOf(
                ContatoV2("1 Rodrigo", "1111"),
                ContatoV2("2 João", "22222"),
                ContatoV2("3 Maria", "33333"),
                ContatoV2("4 Maria", "33333"),
                ContatoV2("5 Maria", "33333"),
                ContatoV2("6 Maria", "33333"),
                ContatoV2("7 Maria", "33333"),
                ContatoV2("8 Maria", "33333"),
                ContatoV2("9 Maria", "33333"),
                ContatoV2("10 Maria", "33333"),
                ContatoV2("11 Maria", "33333"),
                ContatoV2("12 Maria", "33333"),
                ContatoV2("13 Maria", "33333"),
                ContatoV2("14 Maria", "33333"),
                ContatoV2("15 Maria", "33333"),
                ContatoV2("16 Maria", "33333"),
                ContatoV2("17 Maria", "33333"),
                ContatoV2("18 Maria", "33333")
            )
        )
    }
}