package com.solve.math_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    private val random = Random()
    private var resultT = 0
    private var levelCount: Int = 0
    private var rightAnswer = 0
    var wrongAnswer = 0

    companion object {
        const val SCORE_COUNT = 20
        const val ANSWERS_COUNT = "answersCount"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        generateNumbers()
    }

    private fun generateNumbers() {
        levelCount++
        tvScoreEqual.text = levelCount.toString()
        var firstNumber = random.nextInt(100) + 1
        var secondNumber = random.nextInt(100) + 1
        var str = Random().nextInt(4)
        if (firstNumber < secondNumber) {
            firstNumber += secondNumber
            secondNumber = firstNumber - secondNumber
            firstNumber -= secondNumber
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

    private fun generateWrongAnswer(button: Button) {
        var plusOrMinus = Random().nextBoolean()
        when (plusOrMinus) {
            true -> {
                button.text = (resultT + Random().nextInt(10) + 1).toString()
            }
            false -> {
                button.text = (resultT - Random().nextInt(10) - 1).toString()
            }
        }
    }

    fun onClick(view: View) {
        val selectedVariant = (view as Button).text.toString().toInt()
        if (selectedVariant == resultT) {
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            rightAnswer++
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }

        if (levelCount == SCORE_COUNT && rightAnswer == SCORE_COUNT) {
            val win = Intent(this, WinActivity::class.java)
            win.putExtra(ANSWERS_COUNT, rightAnswer)
            Toast.makeText(this, "You Win!", Toast.LENGTH_LONG).show()
            startActivity(win)
            finish()
        } else if (levelCount == SCORE_COUNT && rightAnswer != SCORE_COUNT) {
            val lose = Intent(this, GameOverActivity::class.java)
            lose.putExtra(ANSWERS_COUNT, rightAnswer)
            Toast.makeText(this, "You Lose!", Toast.LENGTH_LONG).show()
            startActivity(lose)
            finish()
        } else {
            generateNumbers()
        }
    }
}
