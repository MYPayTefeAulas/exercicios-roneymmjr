package com.example.meuprimeirapp.AgendaV3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeirapp.databinding.ActivityEditarContatoV3Binding

class EditarContatoV3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoV3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoV3Binding.inflate(layoutInflater)

        setTitle("Editar Contato")

        val indiceContato = intent.getIntExtra("indiceContato", -1)

        val nome: String = AgendaV3.listaContatos[indiceContato].nome
        val telefone: String = AgendaV3.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)

        binding.agendaBtSalvar.setOnClickListener {
            AgendaV3.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            AgendaV3.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, "Contato Salvo com Sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

        setContentView(binding.root)
    }
}