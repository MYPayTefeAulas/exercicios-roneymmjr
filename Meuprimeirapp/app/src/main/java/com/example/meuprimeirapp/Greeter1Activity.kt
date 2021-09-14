package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private var greeterAtual = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreeter1Binding.inflate(layoutInflater)


        val greeter1 = GreeterTipo1("Olá")
        val greeter2 = GreeterTipo1("Bem vindo")
        val greeter3 = GreeterTipo1("Hello")
        listaNomes.add("bebe")
        listaNomes.add("carlos")
        binding.btImprimir.setOnClickListener{
            var nomeAtual = listaNomes[indiceAtual]

        when(greeterAtual){

            1-> binding.txtSaida.text = greeter1.greet(nomeAtual)
            2-> binding.txtSaida.text = greeter2.greet(nomeAtual)
            3-> binding.txtSaida.text = greeter3.greet(nomeAtual)
        }

            if(indiceAtual == listaNomes.size -1){
            indiceAtual = 0
             }else{
            indiceAtual ++

            }
        }
        binding.btTrocar.setOnClickListener{
            if(greeterAtual ==1){
                greeterAtual = 2
                binding.txtNumGreeter.text = "2"

            }else if(greeterAtual==2){
                greeterAtual = 3
                binding.txtNumGreeter.text = "3"
            }else
            {
                greeterAtual = 1
                binding.txtNumGreeter.text = "1"

            }
        }


        setContentView(binding.root)
    }
}