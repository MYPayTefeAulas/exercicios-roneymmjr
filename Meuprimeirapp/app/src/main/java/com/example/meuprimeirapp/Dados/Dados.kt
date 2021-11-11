package com.example.meuprimeirapp.Dados

class Dados(var numeroLados: Int) {

    fun lancar(): String{
        val ladoSorteado =  (1..numeroLados).shuffled().first().toString()
        return ladoSorteado
    }

    fun vidaGuerreiro():Int{
        val ladoSorteado =  (80..100).shuffled().first()
        return ladoSorteado
    }
    fun forcaAtaque():Int{
        val ladoSorteado =  (3..6).shuffled().first()
        return ladoSorteado
    }
    fun incremento(): Int{
        val ladoSorteado =  (1..numeroLados).shuffled().first()
        return ladoSorteado
    }
    fun sortear():Int{
        val ladoSorteado =  (1..4).shuffled().first()
        return ladoSorteado
    }
}