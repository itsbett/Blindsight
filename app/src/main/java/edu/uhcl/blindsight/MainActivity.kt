package edu.uhcl.blindsight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import edu.uhcl.blindsight.diceroller.DiceRoller

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val diceRoller = DiceRoller()
        setContentView(R.layout.activity_main)

        val rolld20: ImageButton = findViewById(R.id.imageButton2)
        val rolld6: ImageButton = findViewById(R.id.imageButton3)
        val stringRoller: Button = findViewById(R.id.button)
        val rollResults: TextView = findViewById(R.id.displayRoll)
        val stringInput: EditText = findViewById(R.id.stringRoll)

        rolld20.setOnClickListener {
            rollResults.text = diceRoller.roll("1d20").toString()
        }
        rolld6.setOnClickListener {
            rollResults.text = diceRoller.roll("1d6").toString()
        }
        stringRoller.setOnClickListener {
            rollResults.text = diceRoller.roll(stringInput.text.toString()).toString()
        }
        //A comment to test

        ///This is some new shit to push.
        ///I want to die.
        // door dash is to expensive...
    }
}