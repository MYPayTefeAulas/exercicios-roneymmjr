package com.example.meuprimeirapp.RPG

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityDadosGuerreiroBinding

class DadosGuerreiroActivity : AppCompatActivity() {
    private lateinit var biding: ActivityDadosGuerreiroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        biding = ActivityDadosGuerreiroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        val dados = intent.extras
        var nome_guerreiro1  = dados?.getString("Guerreiro1")
        var ataque_guerreiro1  = dados?.getInt("Ataque1")
        var vida_guerreiro1  = dados?.getInt("Vida1")
        var nome_guerreiro2  = dados?.getString("Guerreiro2")
        var ataque_guerreiro2  = dados?.getInt("Ataque2")
        var vida_guerreiro2  = dados?.getInt("Vida2")
        biding.txtNome1.text = nome_guerreiro1
        biding.txtForca1.text = ataque_guerreiro1.toString()
        biding.txtVida11.text = vida_guerreiro1.toString()
        biding.txtNomeGuerreiro22.text = nome_guerreiro2
        biding.txtForca22.text = ataque_guerreiro2.toString()
        biding.txtVida22.text = vida_guerreiro2.toString()

        biding.btIniciar.setOnClickListener {
            val intent = Intent(this, BatalhaActivity::class.java)
            intent.putExtra("Guerreiro1",nome_guerreiro1)
            intent.putExtra("Ataque1",ataque_guerreiro1)
            intent.putExtra("Vida1",vida_guerreiro1)
            intent.putExtra("Guerreiro2",nome_guerreiro2)
            intent.putExtra("Ataque2",ataque_guerreiro2)
            intent.putExtra("Vida2",vida_guerreiro2)
            startActivity(intent)
        }
    }
}