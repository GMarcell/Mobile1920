package com.github.gmarcell.randomgenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text)
        rollButton  = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        //val randomInt = Random().nextInt(1)
        val randomFace = arrayListOf("Head", "Tail")
        val random = Random ()
        val randomResult = random.nextInt(randomFace.count())
        resultText.text = randomFace[randomResult]
    }
}
