package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityPessoasBinding
import com.example.meuprimeirapp.databinding.ActivityPessoatabBinding

class PessoatabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPessoatabBinding
    private var nome = ""
    private var idade = 0
    val listasPessoa = mutableListOf<Pessoa>()
    private var indiceAtual = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPessoatabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSalvar.setOnClickListener{
            if(binding.entradaNome.text.isNullOrBlank()||binding.entradaIdade.text.isNullOrBlank())
            {
                binding.txtNome.text = "Insira todos os dados"
            }
            else{
                binding.txtNome.text = ""
                nome = binding.entradaNome.text.toString()
                binding.entradaNome.text.clear()
                idade= binding.entradaIdade.text.toString().toInt()
                binding.entradaIdade.text.clear()
                val pessoa = Pessoa(nome,idade)
                listasPessoa.add(pessoa)
            }

        }
        binding.btPrXimo.setOnClickListener{
            binding.txtNome.text = imprimePessoa()
        }
        binding.btZerar.setOnClickListener{
            binding.txtNome.text = ""
            listasPessoa.clear()
        }
    }
    fun imprimePessoa(): String{
        if(listasPessoa.size==0){
            return "Nenhum dado foi salvo"
        }
        if(indiceAtual >=listasPessoa.size) {
            indiceAtual = 0
            return "Fim da lista"

        }

        val pessoaAtual = listasPessoa[indiceAtual]
        indiceAtual++
        return "Nome: ${pessoaAtual.nome}, Idade: ${pessoaAtual.idade}"

    }

    }
