package com.example.meuprimeirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.Gretter.GreeternewActivity
import com.example.meuprimeirapp.databinding.ActivityTelaInicialBinding

class TelaInicialActivity : AppCompatActivity() {
    private lateinit var binding:ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTelaInicialBinding.inflate(layoutInflater)
        setTitle("TELA DOS APLICATIVOS")


        super.onCreate(savedInstanceState)

        binding.btAbrirAppListas.setOnClickListener{
            val intent = Intent(this@TelaInicialActivity,ListasPessoasActivity::class.java)
            startActivity(intent)
        }
        binding.btAbrirAppGretter.setOnClickListener{
            val intent = Intent(this@TelaInicialActivity,GreeternewActivity::class.java)
            startActivity(intent)
        }
        binding.btAbrirAppSorteioDados.setOnClickListener{
            val intent = Intent(this@TelaInicialActivity,Dados1Activity::class.java)
            startActivity(intent)
        }
        binding.btAbrirAppAgenda.setOnClickListener{
            val intent = Intent(this@TelaInicialActivity,Agenda1Activity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)
    }
}