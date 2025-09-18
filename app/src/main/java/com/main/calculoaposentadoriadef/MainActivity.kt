package com.main.calculoaposentadoriadef

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.main.calculoaposentadoriadef.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Dados para o spinner
        val list = listOf("Masculino", "Feminino")

        //Config Adpter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        //Alocando ao spinner
        binding.spinner.adapter = adapter


        val sexoSelecionado = binding.spinner.selectedItem


        //Ativando Evento de click do botão
        binding.button.setOnClickListener {

            val sexoSelecionado = binding.spinner.selectedItem as String
            var idade = binding.EditTextIdade.text.toString().toLongOrNull()
            var resultado: Long

            if (idade == null || idade <= 0) {
                binding.textView.text = "INFORME UMA IDADE VALIDA"

            } else if (sexoSelecionado == "Masculino" && idade < 65) {
                binding.textView.text = "FALTAM: ${65 - idade} ANOS PARA SUA APOSENTADORIA"
            } else if (sexoSelecionado == "Feminino" && idade < 62) {
                binding.textView.text = "IDADE: ${62 - idade} ANOS PARA SUA APOSENTADORIA"


            } else if (sexoSelecionado == "Masculino" && idade >=65) {
                binding.textView.text = "VOCÊ JA SE APOSENTOU"
            } else if (sexoSelecionado == "Feminino" && idade >= 62) {
                binding.textView.text = "VOCÊ JA SE APOSENTOU"

            }

        }
    }
}