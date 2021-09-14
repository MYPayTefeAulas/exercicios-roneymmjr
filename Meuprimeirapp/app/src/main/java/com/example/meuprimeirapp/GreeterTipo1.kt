package com.example.meuprimeirapp

class GreeterTipo1(val cumprimento: String) {

    fun greet(nome:String):String{
        val comprimentoCompleto = "$cumprimento, $nome"
        return comprimentoCompleto
    }


}