package com.example.meuprimeirapp.RPG

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityHistoricoBinding

class HistoricoActivity : AppCompatActivity() {
    private lateinit var biding: ActivityHistoricoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var vencedor: ArrayList<String>
        var perdedor: ArrayList<String>
        biding = ActivityHistoricoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(biding.root)
        var listaVencedores = mutableListOf<String>()
        var listaPerdedor = mutableListOf<String>()
        val dados = intent.extras
        vencedor = dados?.getStringArrayList("vencedor") as ArrayList<String>
        perdedor = dados?.getStringArrayList("perdedor") as ArrayList<String>
        listaVencedores.add(vencedor.toString())
        listaPerdedor.add(perdedor.toString())
        var numBatalha = 1
        for (x in 0 until listaPerdedor.size-1){
            biding.txtBatalha.text = "$numBatalha      ${vencedor[x]}     ${perdedor[x]}      "
        }

    }
}