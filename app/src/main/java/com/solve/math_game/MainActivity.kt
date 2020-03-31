package com.solve.math_game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlay.setOnClickListener {
            val play = Intent(this, GameActivity::class.java)
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
            startActivity(play)
            finish()
        }

        btnQuit.setOnClickListener {
            Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
