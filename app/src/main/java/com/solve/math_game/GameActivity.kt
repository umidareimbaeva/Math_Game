package com.solve.math_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    private val random = Random()
    private var resultT = 0
    var i : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        generateNumbers()
    }
    private fun generateNumbers(){
        i++
        if(i < 11) {
            tvScoreEqual.text = i.toString()
            var firstNumber = Random().nextInt(100) + 1
            var secondNumber = Random().nextInt(100) + 1
            var str = Random().nextInt(4)
            if (firstNumber < secondNumber) {
                var c = firstNumber
                firstNumber = secondNumber
                secondNumber = c
            }
            when (str) {
                0 -> {
                    tvNumbers.text = "$firstNumber + $secondNumber = ?"
                    resultT = firstNumber + secondNumber
                }
                1 -> {
                    tvNumbers.text = "$firstNumber - $secondNumber = ?"
                    resultT = firstNumber - secondNumber
                }
                2 -> {
                    tvNumbers.text = "$firstNumber * $secondNumber = ?"
                    resultT = firstNumber * secondNumber
                }
                else -> {
                    firstNumber *= secondNumber
                    tvNumbers.text = "$firstNumber / $secondNumber = ?"
                    resultT = firstNumber / secondNumber
                }
            }
            var correctAnswer = Random().nextInt(4)
            generateWrongAnswer(btnA)
            generateWrongAnswer(btnB)
            generateWrongAnswer(btnC)
            generateWrongAnswer(btnD)

            when (correctAnswer) {
                1 -> {
                    btnA.text = "$resultT"
                }
                2 -> {
                    btnB.text = "$resultT"
                }
                3 -> {
                    btnC.text = "$resultT"
                }
                else -> {
                    btnD.text = "$resultT"
                }
            }
        }
        else
        {
            val win = Intent(this, WinActivity::class.java)
            startActivity(win)
            finish()
        }

    }
    private fun generateWrongAnswer(button: Button) {
        var plusOrMinus = Random().nextBoolean()
        when(plusOrMinus){
            true -> {button.text = (resultT + Random().nextInt(10) + 1).toString()}
            false ->{button.text = (resultT - Random().nextInt(10) - 1).toString()}
        }
    }
    fun onClick(view:View){
        val selectedVariant = (view as Button).text.toString().toInt()
        if(selectedVariant == resultT){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            generateNumbers()
        }
        else{
            val lose = Intent(this, GameOverActivity::class.java)
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
            startActivity(lose)
            finish()
        }
    }
}
