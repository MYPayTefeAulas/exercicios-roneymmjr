package com.example.meuprimeirapp

//import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.Dados.Dados
import com.example.meuprimeirapp.RPG.DadosGuerreiroActivity
import com.example.meuprimeirapp.databinding.ActivityRpgBinding

class RpgActivity : AppCompatActivity() {
    private lateinit var biding: ActivityRpgBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val dado1 = Dados(10)

        biding = ActivityRpgBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        biding.btProximo.setOnClickListener {
            if(biding.txtNomeGuerreiro1.text.isEmpty()){
                biding.txtSaidaRPG.text = "Escolha um nome para o player 1"

            }
            if(biding.txtNomeGuerreiro2.text.isEmpty()){
                biding.txtSaidaRPG.text = "Escolha um nome para o player 2"

            }

            else{
                val intent = Intent(this, DadosGuerreiroActivity::class.java)
                //***************************************************************
                val nome1 = biding.txtNomeGuerreiro1.text.toString()
                var forca_guerreiro1 = dado1.forcaAtaque()
                var vida_guerreiro1 = dado1.vidaGuerreiro()
                //*****************************************************
                val nome2 = biding.txtNomeGuerreiro2.text.toString()
                var forca_guerreiro2 = dado1.forcaAtaque()
                var vida_guerreiro2 = dado1.vidaGuerreiro()
                intent.putExtra("Guerreiro1",nome1)
                intent.putExtra("Ataque1",forca_guerreiro1)
                intent.putExtra("Vida1",vida_guerreiro1)
                intent.putExtra("Guerreiro2",nome2)
                intent.putExtra("Ataque2",forca_guerreiro2)
                intent.putExtra("Vida2",vida_guerreiro2)
                startActivity(intent)
            }

        }
    }
}