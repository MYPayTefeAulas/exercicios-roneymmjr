package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula3.Dados
import com.example.meuprimeirapp.databinding.ActivityDados1Binding

class Dados1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDados1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDados1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val dado1 = Dados(6)
        val dado2 = Dados(10)
        val dado3 = Dados(4)

        binding.bt1.setOnClickListener {
            if(!binding.txtEntradadado1.text.isNullOrBlank()&&binding.txtEntradadado1.text.toString().toInt()!=0){
                val numeroLados = binding.txtEntradadado1.text.toString().toInt()
                dado1.numeroLados = numeroLados
                binding.txtNumeroDado1.text = numeroLados.toString()
                binding.txtEntradadado1.text.clear()
            }

        }

        binding.botao2.setOnClickListener {
            if(!binding.txtEntradadado2.text.isNullOrBlank()&&binding.txtEntradadado2.text.toString().toInt()!=0)
            {
                val numeroLados = binding.txtEntradadado2.text.toString().toInt()
                dado2.numeroLados = numeroLados
                binding.txtNumeroDado2.text = numeroLados.toString()
                binding.txtEntradadado2.text.clear()
            }

        }

        binding.botao3.setOnClickListener {
            if(!binding.txtEntradadado3.text.isNullOrBlank()&&binding.txtEntradadado3.text.toString().toInt()!=0){
                val numeroLados = binding.txtEntradadado3.text.toString().toInt()
                dado3.numeroLados = numeroLados
                binding.txtNumeroDado3.text = numeroLados.toString()
                binding.txtEntradadado3.text.clear()
            }

        }

        binding.botaoSortear.setOnClickListener {
            binding.txtSaidadoDado1.text = dado1.lancar()
            binding.txtSaidadoDado2.text = dado2.lancar()
            binding.txtSaidadoDado3.text = dado3.lancar()
        }
    }
}