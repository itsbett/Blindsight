package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.CharacterManager
import edu.uhcl.blindsight.diceroller.StringToDiceRoll
import java.util.*

class CharacterCreationTextToFunction {
    private var currentStep: Int = 0
    private lateinit var characterManager: CharacterManager

    constructor(characterManager: CharacterManager) {
        this.characterManager = characterManager
    }

    fun wordList(line: String): Array<String?>? {
        return line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    fun readText(input: String): String? {
        var inputString = input
        inputString = inputString.uppercase(Locale.getDefault()) //Converts the string to all uppercase for better recognition
        val inputStringArray = TextToFunction.wordList(inputString) //Assigns inputString into a String array
        return when(currentStep) {
            0 -> characterManager.setRace(inputStringArray[0])
            1 -> characterManager.setClass(inputStringArray[0])
            else -> "error"
        }
    }
}