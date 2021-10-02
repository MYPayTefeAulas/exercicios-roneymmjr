package com.example.meuprimeirapp

class Agenda {
    private val listaContatos = mutableListOf<Pessoa1>()
    private var indiceAtual = -1
    var numeroDeContatos = 0
    fun salvarContato(novoContato: Pessoa1): Boolean{
        var auxiliar = true
        for (x in 0..listaContatos.size -1){
            if (listaContatos[x].contato == novoContato.contato){
                auxiliar = false
                break
            }
        }
        return if (auxiliar){
            listaContatos.add(novoContato)
            true
        }else false
    }
    fun removeContato(contatoARemover: Pessoa1): Boolean{

        listaContatos.remove(contatoARemover)
        indiceAtual -=1
        return true
    }
    fun proximoContato():Pessoa1{
        if(indiceAtual < -1){
            indiceAtual = 0
        }
        else if(indiceAtual >= listaContatos.size -1){
            indiceAtual = 0
        }else{
            indiceAtual++
        }
        return listaContatos[indiceAtual]
    }

    fun existeContato(): Boolean{
        if(listaContatos.isEmpty()){
            return true
        }
        return false
    }

    fun pesquisarContato(contato: String): Pessoa1 {

        var contatoPesquisa = Pessoa1("","")
        for (x in 0..listaContatos.size - 1) {
            if (contato == listaContatos[x].contato||contato == listaContatos[x].nome) {
                contatoPesquisa = listaContatos[x]
                numeroDeContatos++
                break
            }
        }
        return contatoPesquisa
    }

}