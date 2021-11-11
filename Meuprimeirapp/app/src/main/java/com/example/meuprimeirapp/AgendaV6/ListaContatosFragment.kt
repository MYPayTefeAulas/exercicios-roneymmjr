package com.example.meuprimeirapp.AgendaV6

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.meuprimeirapp.AgendaCompleta.Agenda
import com.example.meuprimeirapp.AgendaV1.EditarContatoActivity
import com.example.meuprimeirapp.AgendaV6.AgendaV6.listaContatos
import com.example.meuprimeirapp.AgendaV6.utils.IntentsConstants
import com.example.meuprimeirapp.AgendaV6.utils.PrefsConstants
import com.example.meuprimeirapp.R
import com.example.meuprimeirapp.databinding.FragmentListaContatosBinding

class ListaContatosFragment: Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentListaContatosBinding? = null

    private val binding get() = _binding!!

    private lateinit var adapter: ContatosAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)

        adapter = ContatosAdapter(mutableListOf(), ::onBtEditarClick)

        binding.rvContatos.layoutManager = LinearLayoutManager(context)
        binding.rvContatos.adapter = adapter
        binding.rvContatos.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )

        carregaLista()

        initTopBar()

        return binding.root
    }

    private fun carregaLista() {
        val config = requireActivity().getSharedPreferences(PrefsConstants.FILE_CONFIGURACOES, 0)
        val ordenacaoSelecionada_str = config.getString(
            PrefsConstants.KEY_TIPO_ORDENACAO_CONTATOS,
            TipoOrdenacao.ORDEM_INSERCAO.toString()
        )
        val ordenacaoSelecionada: TipoOrdenacao = TipoOrdenacao.valueOf(ordenacaoSelecionada_str!!)
        when (ordenacaoSelecionada) {
            TipoOrdenacao.ALFABETICA_AZ -> {
                val listaOrdenada = AgendaV6.listaContatos.sortedBy { it.nome }
                adapter.swapData(listaOrdenada)
            }
            TipoOrdenacao.ALFABETICA_ZA -> {
                val listaOrdenada = AgendaV6.listaContatos.sortedByDescending { it.nome }
                adapter.swapData(listaOrdenada)
            }
            TipoOrdenacao.ORDEM_INSERCAO -> {
                adapter.swapData(AgendaV6.listaContatos)
            }
        }
    }

    private fun initTopBar() {
        binding.toolbarContatos.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.search_top_bar -> {
                    val searchView = menuItem?.actionView as SearchView
                    searchView.queryHint = "Digite para pesquisar"
                    searchView.setOnQueryTextListener(this)
                    true
                }
                else -> false
            }
        }
    }

    override fun onQueryTextChange(newText: String?): Boolean =
        onQueryTextSubmit(newText) // vai buscar a cada letra digitada

    override fun onQueryTextSubmit(query: String?): Boolean {
        val queryLowerCase = query.toString().lowercase()

        val listaFiltrada = AgendaV6.listaContatos.filter { contatoAtual ->
            contatoAtual.nome.lowercase().contains(queryLowerCase) ||
                    contatoAtual.telefone.lowercase().contains(queryLowerCase)
        }
        adapter.swapData(listaFiltrada)
        return true
    }

    override fun onResume() {
        super.onResume()
        carregaLista()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onBtEditarClick(indiceLista: Int) {
        val intent = Intent(context, EditarContatoActivity::class.java)
        intent.putExtra(IntentsConstants.INT_INDICE_CONTATO, indiceLista)
        startActivity(intent)
    }

}