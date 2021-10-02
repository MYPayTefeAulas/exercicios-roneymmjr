package com.example.aula3

class Dados(var numeroLados: Int) {

    fun lancar(): String{
        val ladoSorteado =  (1..numeroLados).shuffled().first().toString()
        return ladoSorteado
    }

}