package com.example.meuprimeirapp.Exerciciocalculodobro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btTrocar.setOnClickListener() {
            // trocarTexto()
            // binding.Trocartexto.text = trocaTexto2()
            binding.Trocartexto.text = calcularDobro()
        }
        val view = binding.root
        setContentView(view)
    }

    fun calcularDobro(): String {
        val textoEntrada = binding.txtInput.text.toString()
        val numero = textoEntrada.toInt()
        val dobro = numero * 2
        return dobro.toString()
    }

    //fun trocarTexto(){
    //    binding.Trocartexto.text = "oi"
    //}
    fun trocarTexto(): String {
        return "oi bb"
    }

    fun trocaTexto2(): String {
        return binding.txtInput.text.toString()

    }
}