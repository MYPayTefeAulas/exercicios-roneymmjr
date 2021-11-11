package com.example.meuprimeirapp.AgendaV5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeirapp.databinding.ActivityEditarContatoV5Binding

class EditarContatoV5Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoV5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoV5Binding.inflate(layoutInflater)

        setTitle("Editar Contato")

        val indiceContato = intent.getIntExtra("indiceContato", -1)

        val nome: String = AgendaV5.listaContatos[indiceContato].nome
        val telefone: String = AgendaV5.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)

        binding.agendaBtSalvar.setOnClickListener {
            AgendaV5.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            AgendaV5.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, "Contato Salvo com Sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

        setContentView(binding.root)
    }
}