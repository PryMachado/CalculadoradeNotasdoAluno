package com.example.calculadoradenotasdoaluno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculadoradenotasdoaluno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.btCalcular.setOnClickListener {
            val nota1 = bindind.editNota1.text.toString()
            val nota2 = bindind.editNota2.text.toString()
            val nota3 = bindind.editNota3.text.toString()
            val nota4 = bindind.editNota4.text.toString()
            val numeroFaltas = bindind.editFaltas.text.toString()

            if (nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty() || numeroFaltas.isEmpty()) {
                bindind.txtResultado.setText("Preencha todos os campos!")
                bindind.txtResultado.setTextColor(getColor(R.color.red))

            } else {
                calcularMedia(
                    nota1.toInt(),
                    nota2.toInt(),
                    nota3.toInt(),
                    nota4.toInt(),
                    numeroFaltas.toInt()
                )
            }

        }
    }

    fun calcularMedia(nota1: Int, nota2: Int, nota3: Int, nota4: Int, numeroFaltas: Int) {
        val media = (nota1 + nota2 + nota3 + nota4) / 4

        if (media >=5 && numeroFaltas <=20){
            bindind.txtResultado.setText("Aluno foi Aprovado  \n Media final: $media")
            bindind.txtResultado.setTextColor(getColor(R.color.verdeClaro))
        }else if (numeroFaltas >20){
            bindind.txtResultado.setText("Aluno foi Reprovado por Faltas  \n Media final: $media")
            bindind.txtResultado.setTextColor(getColor(R.color.red))
        }else if (media <5){
            bindind.txtResultado.setText("Aluno foi Reprovado por Nota  \n Media final: $media")
            bindind.txtResultado.setTextColor(getColor(R.color.red))
        }
    }
}