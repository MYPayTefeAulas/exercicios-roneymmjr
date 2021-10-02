package com.example.meuprimeirapp

class Pessoa1 {

    var nome = ""
    var idade = 0
    var contato: String = ""
    constructor(nome: String,idade: Int)
    {
        this.nome = nome
        this.idade = idade
    }
    constructor(nome: String, contato: String){
        this.nome = nome
        this.contato = contato
    }

}