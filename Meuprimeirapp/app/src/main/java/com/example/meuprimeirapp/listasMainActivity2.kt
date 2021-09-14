package com.example.meuprimeirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityListasMain2Binding
import com.example.meuprimeirapp.databinding.ActivityMainBinding

class listasMainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityListasMain2Binding
    private val listasFrutas = listOf("maca", "mamao", "abacate")
    private val listasVegetais = listOf("pepino", "alface", "pimentao")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListasMain2Binding.inflate(layoutInflater)
        binding.btAnalisar.setOnClickListener{
            binding.txtSaida.text = analisar(binding.txtEntrada.text.toString())
        }


        setContentView(binding.root)
    }

    fun analisar(entrada: String): String {
        var saida = ""
        for (fruta in listasFrutas) {
            if (fruta == entrada) {
                saida = " é uma fruta"
                break
            }

            for (vegetal in listasVegetais){
                if(vegetal == entrada) {
                 saida = " é um vegetal"
                    break
                }

            }
            if(saida =="")
                saida = "nao sei o que é isso"

        }
        return saida
    }
    }
