package com.example.meuprimeirapp.RPG

import com.example.meuprimeirapp.Dados.Dados

class Arena(val guerreiro1: Guerreiro, val guerreiro2: Guerreiro) {
    val dado1 = Dados(0)
    fun jogarProximoTurno(){
        guerreiro1.forcaAtaque = dado1.forcaAtaque()
        guerreiro1.vidaMaxima = dado1.vidaGuerreiro()
        guerreiro2.forcaAtaque = dado1.forcaAtaque()
        guerreiro2.vidaMaxima = dado1.vidaGuerreiro()
    }
    fun obterTextoExibicao(): String {
        var retorno = "Guerreiro 1 : ${guerreiro1.nome}          Guerreiro 2 : ${guerreiro2.nome}\n\n\n   Vida : ${guerreiro1.vidaAtual}                        Vida : ${guerreiro2.vidaAtual}"
        return retorno
    }
}