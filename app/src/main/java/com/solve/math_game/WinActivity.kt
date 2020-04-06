package com.solve.math_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_game_over.*
import kotlinx.android.synthetic.main.activity_win.*

class WinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win)

        var rightAnswer = intent.getIntExtra(GameActivity.ANSWERS_COUNT, 0)
        tvYourScore.text = "$rightAnswer / ${GameActivity.SCORE_COUNT}"

        btnRestart.setOnClickListener {
            val game = Intent(this, GameActivity::class.java)
            Toast.makeText(this,"New Game", Toast.LENGTH_SHORT).show()
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(game)
            finish()
        }

        btnMainM.setOnClickListener {
            val mainMenu = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            Toast.makeText(this, "Main Menu", Toast.LENGTH_SHORT).show()
            startActivity(mainMenu)
            finish()
        }
    }
}
