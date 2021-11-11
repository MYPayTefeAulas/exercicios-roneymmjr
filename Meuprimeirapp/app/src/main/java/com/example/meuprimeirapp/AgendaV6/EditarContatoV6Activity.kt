package com.example.meuprimeirapp.AgendaV6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.meuprimeirapp.AgendaV6.utils.IntentsConstants
import com.example.meuprimeirapp.R
import com.example.meuprimeirapp.databinding.ActivityEditarContatoV6Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class EditarContatoV6Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarContatoV6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarContatoV6Binding.inflate(layoutInflater)

        setTitle(getString(R.string.editar_contato))

        val indiceContato = intent.getIntExtra(IntentsConstants.INT_INDICE_CONTATO, -1)

        val nome: String = AgendaV6.listaContatos[indiceContato].nome
        val telefone: String = AgendaV6.listaContatos[indiceContato].telefone
        binding.agendaTxtTelefone.setText(telefone)
        binding.agendaTxtNome.setText(nome)
        binding.switchContatoFavorito.isChecked = AgendaV6.listaContatos[indiceContato].favorito

        binding.agendaBtSalvar.setOnClickListener {
            AgendaV6.listaContatos[indiceContato].nome = binding.agendaTxtNome.text.toString()
            AgendaV6.listaContatos[indiceContato].telefone = binding.agendaTxtTelefone.text.toString()
            Toast.makeText(this, getString(R.string.contato_salvo), Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btDeletar.setOnClickListener {
            val dialog = MaterialAlertDialogBuilder(this)
                .setTitle(getString(R.string.deletar_contato))
                .setMessage(getString(R.string.realmente_deletar))
                .setNegativeButton(getString(R.string.cancelar), null)
                .setPositiveButton(getString(R.string.deletar)) { _, _ ->
                    AgendaV6.listaContatos.removeAt(indiceContato)
                    Toast.makeText(this, getString(R.string.contato_removido), Toast.LENGTH_SHORT).show()
                    finish()
                }
            dialog.show()
        }

        binding.switchContatoFavorito.setOnCheckedChangeListener { _, isChecked ->
            AgendaV6.listaContatos[indiceContato].favorito = isChecked
        }

        setContentView(binding.root)
    }
}