package com.example.meuprimeirapp.AgendaV5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.meuprimeirapp.R
import com.example.meuprimeirapp.databinding.ActivityTelaInicialV5Binding

class TelaInicialV5Activity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialV5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialV5Binding.inflate(layoutInflater)
        setTitle("AGENDAV5")

        inicializaLista()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, ListaContatosFragment())
            .commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> {
                    loadFragments(ListaContatosMelhoradaFragment(), FRAGMENT_HOME)
                    true
                }
                R.id.ic_ajustes -> {
                    loadFragments(AjustesFragment(), FRAGMENT_AJUSTES)
                    true
                }
                else ->
                    false
            }
        }

        setContentView(binding.root)
    }

    //Carrega os fragments e os empilha
    private fun loadFragments(fragment: Fragment, tag: String){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment, tag)
            commit()
        }
    }

    private fun inicializaLista() {
        AgendaV5.listaContatos.addAll(
            listOf(
                Contato(" Lima", "12345"),
                Contato("Luis Felipe INÁCIO", "12345"),
                Contato("Israel da Silva", "12345"),
                Contato("Vanessa Sobral", "33333"),
                Contato("José Augusto", "33333"),
                Contato("Pedro Henrique", "33333"),
                Contato("William Miguel", "12345"),
                Contato("Robert Luis", "12345"),
                Contato("Varlei Barbosa", "12345"),
                Contato("Sabrina de Souza", "12345"),
                Contato("Jéssica Rodrigues", "33333"),
                Contato("Ivan Carvalho", "12345"),
                Contato("Mario Mascarenhas", "33333"),
                Contato("MARIA CAROLINE", "12345"),
                Contato("RONEY JUNIOR", "12345"),
                Contato("Milena Dias", "12345"),
                Contato("Ecson Gama", "12345"),
                Contato("Maria Garcia", "33333"),
                Contato("RAIANE FERREIRA", "12345"),
                Contato("JAQUELINE LIMA", "12345"),
                Contato("Larissa Da Silva", "12345"),
                Contato("Erigeyce Gama", "12345"),
                Contato("Rodrigo Bernardino", "33333"),
                Contato("Narla Chagas", "12345"),
                Contato("Luiz Felipe de SOUZA", "12345"),
                Contato("Keitiane Nogueira", "12345"),
                Contato("Thalia de Souza", "12345"),
                Contato("José Santos", "33333"),
                Contato("Alex", "12345")
            )
        )
    }

    companion object {
        private const val FRAGMENT_HOME = "FRAGMENT_HOME"
        private const val FRAGMENT_AJUSTES = "FRAGMENT_AJUSTES"
    }
}