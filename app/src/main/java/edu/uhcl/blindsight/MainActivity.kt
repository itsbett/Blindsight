package edu.uhcl.blindsight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var diceRoller = DiceRoller()
        val roll = diceRoller.roll("1d6")
        setContentView(R.layout.activity_main)

        val rolld20: ImageButton = findViewById(R.id.imageButton2)
        val rolld6: ImageButton = findViewById(R.id.imageButton3)
        val rollResults: TextView = findViewById(R.id.displayRoll)

        rolld20.setOnClickListener {
            rollResults.text = diceRoller.roll("1d20").toString()
        }
        rolld6.setOnClickListener {
            rollResults.text = diceRoller.roll("1d6").toString()
        }
    }
}