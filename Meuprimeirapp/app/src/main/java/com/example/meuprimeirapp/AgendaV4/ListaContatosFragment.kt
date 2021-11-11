package com.example.meuprimeirapp.AgendaV4

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meuprimeirapp.databinding.FragmentListaContatosBinding

class ListaContatosFragment: Fragment(){
    private var _binding: FragmentListaContatosBinding? = null


    private val binding get() = _binding!!

    private lateinit var adapter: ContatoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)

        adapter = ContatoAdapter(mutableListOf(), ::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(context)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

        inicializaLista()
        adapter.swapData(AgendaV4.listaContatos)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        adapter.swapData(AgendaV4.listaContatos)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun inicializaLista() {
        AgendaV4.listaContatos.addAll(
            listOf(
                Contato("1 Rodrigo", "1111"),
                Contato("2 João", "22222"),
                Contato("3 Maria", "33333"),
                Contato("4 Maria", "33333"),
                Contato("5 Maria", "33333"),
                Contato("6 Maria", "33333"),
                Contato("7 Maria", "33333"),
                Contato("8 Maria", "33333"),
                Contato("9 Maria", "33333"),
                Contato("10 Maria", "33333"),
                Contato("11 Maria", "33333"),
                Contato("12 Maria", "33333"),
                Contato("13 Maria", "33333"),
                Contato("14 Maria", "33333"),
                Contato("15 Maria", "33333"),
                Contato("16 Maria", "33333"),
                Contato("17 Maria", "33333"),
                Contato("19 Maria", "33333"),
                Contato("20 Maria", "33333"),
                Contato("21 Maria", "33333"),
                Contato("22 Maria", "33333"),
                Contato("23 Maria", "33333"),
                Contato("24 Maria", "33333"),
                Contato("25 Maria", "33333"),
                Contato("26 Maria", "33333"),
                Contato("27 Maria", "33333"),

                )
        )
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(context, EditarContatoV4Activity::class.java)
        intent.putExtra("indiceContato", indiceLista)
        startActivity(intent)
    }

}