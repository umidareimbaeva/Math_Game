package com.solve.math_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        var wrongAnswers = intent.getIntExtra(GameActivity.ANSWERS_COUNT, 0)
        tvTextGameOver.text = "$wrongAnswers / ${GameActivity.SCORE_COUNT}"

        btnRestartOver.setOnClickListener{
            val newGame = Intent(this, GameActivity::class.java)
            Toast.makeText(this,"New Game", Toast.LENGTH_SHORT).show()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(newGame)
            finish()
        }

        btnMainMOver.setOnClickListener {
            val mainMenu = Intent(this, MainActivity::class.java)
            Toast.makeText(this, "Main Menu", Toast.LENGTH_SHORT).show()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(mainMenu)
            finish()
        }
    }
}
