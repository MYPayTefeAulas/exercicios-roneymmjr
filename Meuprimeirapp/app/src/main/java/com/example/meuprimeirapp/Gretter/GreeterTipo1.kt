package com.example.meuprimeirapp.Gretter

import com.example.meuprimeirapp.AgendaCompleta.Pessoa

class GreeterTipo1 {
    var cumprimento: String = ""
    var prefixo: String = ""
    var sufixo: String = ""
    constructor(cumprimento: String){
        this.cumprimento = cumprimento
    }

    constructor(prefixo: String, sufixo: String){
        this.prefixo = prefixo
        this.sufixo = sufixo
    }
    fun greet(nome:String):String{
        val comprimentoCompleto = "$cumprimento, $nome"
        return comprimentoCompleto
    }
    fun greet2(pessoa: Pessoa): String{
        return "$prefixo ${pessoa.nome} $sufixo ${pessoa.idade}"
    }


}