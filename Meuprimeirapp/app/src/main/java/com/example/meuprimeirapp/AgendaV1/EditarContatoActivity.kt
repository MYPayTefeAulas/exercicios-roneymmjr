package com.example.meuprimeirapp.AgendaV1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeirapp.AgendaV1.Agendav1
import com.example.meuprimeirapp.databinding.ActivityEditarContatoBinding

class EditarContatoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoBinding.inflate(layoutInflater)

        setTitle("Editar Contato")

        val indiceContato = intent.getIntExtra("indiceContato", -1)

        val nome: String = Agendav1.listaContatos[indiceContato].nome
        val telefone: String = Agendav1.listaContatos[indiceContato].telefone
        binding.txtTelefone1.setText(telefone)
        binding.txtNome1.setText(nome)

        binding.btSalvar1.setOnClickListener {
            Agendav1.listaContatos[indiceContato].nome = binding.txtNome1.text.toString()
            Agendav1.listaContatos[indiceContato].telefone = binding.txtTelefone1.text.toString()
            Toast.makeText(this, "Usuario Salvo com Sucesso!", Toast.LENGTH_SHORT).show()

            finish()
        }

        setContentView(binding.root)
    }
}
