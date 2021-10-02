package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityGreeternewBinding

class GreeternewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeternewBinding
    private var nome = ""
    private var idade = 0
    val listasPessoa = mutableListOf<Pessoa>()
    private var indiceAtual = 0
    //private var greeterAtual = 1



    override fun onCreate(savedInstanceState: Bundle?) {

        val greeter1 = GreeterTipo1("Olá","sua idade é ")
        val greeter2 = GreeterTipo1("Bem vindo","de idade")
        val greeter3 = GreeterTipo1("to welcome: ", "idade")
        super.onCreate(savedInstanceState)
        binding = ActivityGreeternewBinding.inflate(layoutInflater)
        setContentView(binding.root)
var greeterAtual = greeter1
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

         val pessoaAtual = listasPessoa[indiceAtual]
            binding.txtNome.text = greeterAtual.greet2(pessoaAtual)
            if(indiceAtual == listasPessoa.size -1){

                indiceAtual = 0
            }else{
                indiceAtual++
            }

        }

        binding.btTrocar.setOnClickListener{
            if(greeterAtual ==greeter1){
                binding.txtNumGreeter.text = "2"
                greeterAtual = greeter2

            }else if(greeterAtual==greeter2){

                binding.txtNumGreeter.text = "3"
                greeterAtual = greeter3
            }else
            {
              greeterAtual = greeter1
                binding.txtNumGreeter.text = "1"

            }
        }


    }

    }
