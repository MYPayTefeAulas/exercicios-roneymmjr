package com.example.meuprimeirapp.VersoesAgenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.meuprimeirapp.AgendaV1.TelaInicialAgendaActivity
import com.example.meuprimeirapp.AgendaV3.TelaInicialV3Activity
import com.example.meuprimeirapp.AgendaV4.TelaInicialV4Activity
import com.example.meuprimeirapp.AgendaV5.TelaInicialV5Activity
import com.example.meuprimeirapp.AgendaV6.TelaInicialV6Activity
import com.example.meuprimeirapp.Agendav2.TelaInicialV2Activity
import com.example.meuprimeirapp.databinding.ActivityTelaInicialVersoesAgendaBinding

class TelaInicialVersoesAgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTelaInicialVersoesAgendaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTelaInicialVersoesAgendaBinding.inflate(layoutInflater)
        setTitle("VERSOES AGENDA")
        super.onCreate(savedInstanceState)

        binding.btV2.setOnClickListener{
            val intent = Intent(this, TelaInicialV2Activity::class.java)
            startActivity(intent)
        }
        binding.btV1.setOnClickListener{
            val intent = Intent(this,TelaInicialAgendaActivity::class.java)
            startActivity(intent)
        }

        binding.btV3.setOnClickListener{
            val intent = Intent(this, TelaInicialV3Activity::class.java)
            startActivity(intent)
        }

        binding.btV4.setOnClickListener{
            val intent =  Intent(this, TelaInicialV4Activity::class.java)
            startActivity(intent)
        }
        binding.btV5.setOnClickListener{
            val intent = Intent(this, TelaInicialV5Activity::class.java)
            startActivity(intent)
        }
        binding.btV6.setOnClickListener{
            val intent = Intent(this, TelaInicialV6Activity::class.java)
            startActivity(intent)
        }

        setContentView(binding.root)




    }
}