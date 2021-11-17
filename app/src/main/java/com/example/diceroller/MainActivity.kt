package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


//Esta atividade permite ao usuário lançar um dado e ver o resultado na tela.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRolar: Button = findViewById(R.id.buttonRolar)
        buttonRolar.setOnClickListener { rollDice() }

        rollDice()
    }

    //Lança os dados e atualiza a tela com o resultado.
    private fun rollDice() {
        //Crie um novo objeto de Dados com 6 lados e role-o
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encontre o ImageView no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //Determine qual ID de recurso drawable usar com base na jogada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Atualize o ImageView com o ID de recurso drawable correto
        diceImage.setImageResource(drawableResource)

        //Atualize a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}

/*
Use setImageResource() para mudar a imagem exibida na ImageView.
Use declarações de fluxo de controle, como expressões if / else ou when,
para processar diferentes casos no app. Por exemplo, exibir imagens diferentes
em circunstâncias diferentes.
 */