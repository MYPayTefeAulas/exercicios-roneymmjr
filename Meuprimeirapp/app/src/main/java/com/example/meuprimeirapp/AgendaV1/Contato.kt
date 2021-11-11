package com.example.meuprimeirapp.AgendaV1

data class Contato(var nome: String, var telefone: String) {

   override fun toString(): String {
        return "$nome - $telefone"
    }
}