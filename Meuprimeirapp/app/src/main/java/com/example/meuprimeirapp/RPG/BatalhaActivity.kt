package com.example.meuprimeirapp.RPG

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityBatalhaBinding

class BatalhaActivity : AppCompatActivity() {
    private lateinit var biding: ActivityBatalhaBinding
    var proximoTurno  = false
    override fun onCreate(savedInstanceState: Bundle?) {
        val dados = intent.extras
        val nome_guerreiro1  = dados?.getString("Guerreiro1")
        val ataque_guerreiro1  = dados?.getInt("Ataque1")
        val vida_guerreiro1  = dados?.getInt("Vida1")
        val nome_guerreiro2  = dados?.getString("Guerreiro2")
        val ataque_guerreiro2  = dados?.getInt("Ataque2")
        val vida_guerreiro2  = dados?.getInt("Vida2")
        val guerreiro1 = Guerreiro(nome_guerreiro1!!,ataque_guerreiro1!!,vida_guerreiro1!!)
        val guerreiro2 = Guerreiro(nome_guerreiro2!!,ataque_guerreiro2!!,vida_guerreiro2!!)
        val arena = Arena(guerreiro1,guerreiro2)
        biding = ActivityBatalhaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        biding.txtSaidaRPGB.text = arena.obterTextoExibicao()
        biding.btAtacar.setOnClickListener {
            if(proximoTurno){
                biding.txtResultado.text = "A batalha terminou, clique em jogar próximo turno"
            }else{//+++++++++++++++++

                biding.barra1.max = vida_guerreiro1
                biding.barra1.progress += guerreiro2.ataque
                biding.barra2.max= vida_guerreiro2
                biding.barra2.progress += guerreiro1.ataque
                guerreiro1.atacar(guerreiro2)
                guerreiro2.atacar(guerreiro1)
                if (guerreiro1.vidaAtual>0&&guerreiro2.vidaAtual>0){
                    biding.txtAvisos.text = "O guerreiro ${guerreiro1.nome} recebeu ${guerreiro2.ataque} de dano\n\nO guerreiro ${guerreiro2.nome} recebeu ${guerreiro1.ataque} de dano"
                }else{
                    if(guerreiro1.vidaAtual<=0&&guerreiro2.vidaAtual<=0){
                        biding.txtResultado.text = "A batalha empatou"
                        proximoTurno = true
                    }
                    else if(guerreiro1.vidaAtual<=0){
                        guerreiro1.vidaAtual = 0
                        biding.txtResultado.text = "O guerreiro ${guerreiro2.nome} venceu"
                        proximoTurno = true

                    }
                    else if(guerreiro2.vidaAtual<=0){
                        guerreiro2.vidaAtual = 0
                        biding.txtResultado.text = "O guerreiro ${guerreiro1.nome} venceu"
                        proximoTurno = true
                    }
                }

            }//++++++++++++++++++++++
            biding.txtSaidaRPGB.text = arena.obterTextoExibicao()
        }
        biding.btProximoTurno.setOnClickListener {
            if(guerreiro1.vidaAtual>0&&guerreiro2.vidaAtual>0){
                biding.txtResultado.text = "Termine a batalha atual"
            }else{
                val intent = Intent(this, DadosGuerreiroActivity::class.java)
                biding.barra1.progress = 0
                biding.barra2.progress = 0
                proximoTurno = false
                arena.jogarProximoTurno()
                biding.txtSaidaRPGB.text = arena.obterTextoExibicao()
                biding.txtResultado.text = ""
                intent.putExtra("Guerreiro1",guerreiro1.nome)
                intent.putExtra("Ataque1",guerreiro1.forcaAtaque)
                intent.putExtra("Vida1",guerreiro1.vidaMaxima)
                intent.putExtra("Guerreiro2",guerreiro2.nome)
                intent.putExtra("Ataque2",guerreiro2.forcaAtaque)
                intent.putExtra("Vida2",guerreiro2.vidaMaxima)
                startActivity(intent)
            }

        }

    }
}