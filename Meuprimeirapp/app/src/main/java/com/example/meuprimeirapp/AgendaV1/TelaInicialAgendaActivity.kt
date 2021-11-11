package com.example.meuprimeirapp.AgendaV1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.meuprimeirapp.databinding.ActivityTelaInicialAgendaBinding

class TelaInicialAgendaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialAgendaBinding

    private lateinit var adapter: ArrayAdapter<Contato>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTelaInicialAgendaBinding.inflate(layoutInflater)

        setTitle("AGENDA V1")

        Agendav1.listaContatos.add(Contato("1 Batos", "6668"))
        Agendav1.listaContatos.add(Contato("2 Tiago", "6666"))
        Agendav1.listaContatos.add(Contato("3 Mateus", "6661"))
        Agendav1.listaContatos.add(Contato("4 Hugo", "6662"))
        Agendav1.listaContatos.add(Contato("5 Teresa", "6663"))
        Agendav1.listaContatos.add(Contato("6 Levandovisk", "6664"))
        Agendav1.listaContatos.add(Contato("7 Marta", "6665"))
        Agendav1.listaContatos.add(Contato("8 Messi", "6667"))
        Agendav1.listaContatos.add(Contato("9 Lukaku", "6669"))
        Agendav1.listaContatos.add(Contato("10 Hazard", "7000"))
        Agendav1.listaContatos.add(Contato("11 Mia", "7001"))
        Agendav1.listaContatos.add(Contato("12 Julia", "7002"))
        Agendav1.listaContatos.add(Contato("13 Lukas", "7003"))
        Agendav1.listaContatos.add(Contato("14 Hartr", "7004"))

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Agendav1.listaContatos)
        binding.lvContatosAgenda.adapter = adapter
        binding.lvContatosAgenda.setOnItemClickListener { parent, view, position, id ->
         val contato = adapter.getItem(position)
           Toast.makeText(this, "${contato!!.nome}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, EditarContatoActivity::class.java)
            intent.putExtra("indiceContato", position)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

}