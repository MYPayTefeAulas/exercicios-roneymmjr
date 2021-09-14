package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityPessoasBinding

class PessoasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPessoasBinding

    private var nome=""
    private var idade= 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPessoasBinding.inflate(layoutInflater)

        binding.btImprimir.setOnClickListener{

            binding.txtSaida.text = imprimirPessoa()
        }
        binding.btSalvar.setOnClickListener{
        nome = binding.txtNome.text.toString()
            binding.txtNome.text.clear()
        idade = binding.txtIdade.text.toString().toInt()
            binding.txtIdade.text.clear()
        }

        setContentView(binding.root)
    }
    fun imprimirPessoa():String{
    return "nome: $nome, Idade: $idade"

    }

}