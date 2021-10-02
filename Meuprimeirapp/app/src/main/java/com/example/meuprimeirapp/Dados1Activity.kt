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
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        val dado1 = Dados(6)// Dado 1
        val dado2 = Dados(10)// Dado 2
        val dado3 = Dados(4)// Dado 3

        // *************************************************


        // ******************** Configurações do botão de Ok do dado 1 ****************

        binding.bt1.setOnClickListener {
            if(!binding.txtEntradadado1.text.isNullOrBlank()&&binding.txtEntradadado1.text.toString().toInt()!=0){// será executado somente se o campo que altera o numero de lados do dado for preenchido
                val numeroLados = binding.txtEntradadado1.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado1.numeroLados = numeroLados// alterando o número de lados do dado 1 que inicialmente é 6, para a quantidade de lados que foi digitada
                binding.txtNumeroDado1.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 1 possui, para o valor que foi digitado
                binding.txtEntradadado1.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }
        // ****************************************************************************


        // ******************** Configurações do botão de Ok do dado 2 ****************

        binding.botao2.setOnClickListener {
            if(!binding.txtEntradadado2.text.isNullOrBlank()&&binding.txtEntradadado2.text.toString().toInt()!=0)// será executado somente se o campo que altera o numero de lados do dado for preenchido
            {
                val numeroLados = binding.txtEntradadado2.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado2.numeroLados = numeroLados// alterando o número de lados do dado 2 que inicialmente é 10, para a quantidade de lados que foi digitada
                binding.txtNumeroDado2.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 2 possui, para o valor que foi digitado
                binding.txtEntradadado2.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }

        // ****************************************************************************


        // ******************** Configurações do botão de Ok do dado 3 ****************

        binding.botao3.setOnClickListener {
            if(!binding.txtEntradadado3.text.isNullOrBlank()&&binding.txtEntradadado3.text.toString().toInt()!=0){// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                val numeroLados = binding.txtEntradadado3.text.toString().toInt()// variavel que recebe a o numero, que representa a quantidade de lados, que será digitado
                dado3.numeroLados = numeroLados// alterando o número de lados do dado 3 que inicialmente é 4, para a quantidade de lados que foi digitada
                binding.txtNumeroDado3.text = numeroLados.toString()// alterando o texto, que mostra a quantidade de lados que o dado 3 possui, para o valor que foi digitado
                binding.txtEntradadado3.text.clear()// limpando o campo após ser digitada a quantidade do número de lados que o dado irá possuir
            }

        }

        // ****************************************************************************


        // ******************** Configurações do botão Sortear ************************

        binding.botaoSortear.setOnClickListener {
            binding.txtSaidadoDado1.text = dado1.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 1
            binding.txtSaidadoDado2.text = dado2.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 2
            binding.txtSaidadoDado3.text = dado3.lancar()// mostrando o primeiro valor do intervalo que vai de  1 até o número de lados do dado 3
        }

        // ****************************************************************************


    }
}