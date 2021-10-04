package com.example.meuprimeirapp

import android.graphics.Color.green
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.databinding.ActivityAgenda1Binding

class Agenda1Activity : AppCompatActivity() {
//++++++++++++++++++++++++++++++++++++++++++++++
    private lateinit var binding:ActivityAgenda1Binding
    val agenda = Agenda()
    var contatoAtual = Pessoa1("","")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAgenda1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding.btSalvarContato.setOnClickListener{
            val nome = binding.txtEntradaAg.text.toString()
            val contato = binding.txtEntradaTagenda.text.toString()
            salvarContato(nome,contato)
        }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding.btProxContato.setOnClickListener{
            if(agenda.existeContato()){
                binding.txtSaidaAgd.text = "Lista vazia"
            }else{
                contatoAtual = agenda.proximoContato()
                binding.txtEntradaAg.setText(contatoAtual.nome)
                binding.txtEntradaTagenda.setText(contatoAtual.contato)
            }

        }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding.bt1Deletar.setOnClickListener{
            if(!agenda.existeContato()){
                val nome = binding.txtEntradaAg.text.toString()
                val telefone = binding.txtEntradaTagenda.text.toString()
                if(nome == "" && telefone == ""){

                }else{
                    binding.txtSaidaAgd.setTextColor(resources.getColor(R.color.red))
                    binding.txtSaidaAgd.text = "${contatoAtual.nome} foi removido"
                    agenda.removeContato(contatoAtual)
                    binding.txtEntradaAg.text.clear()
                    binding.txtEntradaTagenda.text.clear()
                }
            }
        }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding.bt1Pesquisar.setOnClickListener{
            var contato = binding.txt1EntradaPesquisa.text.toString()
            pesquisar(contato)
        }
    }


    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Criar as funçoes
    private fun salvarContato(nome: String,contato:String ){
        if(nome.isNullOrBlank()){
            binding.txtSaidaAgd.setTextColor(resources.getColor(R.color.purple_700))
            binding.txtSaidaAgd.text = "Nome vazio"
        }else if(contato.isNullOrBlank()){
            binding.txtSaidaAgd.setTextColor(resources.getColor(R.color.purple_700))
            binding.txtSaidaAgd.text = "Telefone vazio"
        }else{
            val novoContato = Pessoa1(nome,contato)

            if(agenda.salvarContato(novoContato)){
                binding.txtSaidaAgd.setTextColor(resources.getColor(R.color.green))
                binding.txtSaidaAgd.text = "Contato ${novoContato.nome} salvo"
                binding.txtEntradaAg.text.clear()
                binding.txtEntradaTagenda.text.clear()
            }else{
                binding.txtSaidaAgd.setTextColor(resources.getColor(R.color.red))
                agenda.removeContato(novoContato)
                binding.txtSaidaAgd.text = "ERRO: Contato já existe"
            }
        }

    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
fun pesquisar(contato: String){
    if(contato == ""){
        binding.txtSaidaAgd.text = ("Campo de pesquisa vazio")
    }else{
        if(agenda.pesquisarContato(contato).nome == ""){
            binding.txtSaidaAgd.text = "O contato $contato não consta na lista"
        }else{
            if (!agenda.existeContato()){
                binding.txtEntradaTagenda.setText(agenda.pesquisarContato(contato).contato)
                binding.txtEntradaAg.setText(agenda.pesquisarContato(contato).nome)
            }
        }

    }
}

}



