package com.example.meuprimeirapp.Agendav2

data class ContatoV2(var nome: String, var telefone: String){
    val id = getProximoId()

    companion object {
        var lastId = -1

        fun getProximoId(): Int {
            return lastId++
        }
    }
}

