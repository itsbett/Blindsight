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

            //CHOOSE RACE
            0 ->
            {
                if (characterManager.setRace(inputStringArray[0]) == 0) {
                    this.currentStep++
                    return "Race set to $inputStringArray[0]"
                } else {
                    return "Race not found."
                }
            }

            //CHOOSE CLASS
            1 ->
            {
                if (characterManager.setClass(inputStringArray[0]) == 0) {
                    this.currentStep++
                    return "Class set to $inputStringArray[0]"
                } else {
                    return "Class not found."
                }
            }

            //CHOOSE HEIGHT
            2 ->
            {
                if (characterManager.setHeight(inputStringArray[0]) == 0) {
                    this.currentStep++
                    return "Height set to $inputStringArray[0]"
                } else {
                    return "Height could not be set"
                }
            }

            //CHOOSE WEIGHT
            3 ->
            {
                if (characterManager.setWeight(inputStringArray[0]) == 0) {
                    this.currentStep++
                    return "Weight set to $inputStringArray[0]"
                } else {
                    return "Weight could not be set."
                }
            }

            4 ->
            {
                if (characterManager.setClass(inputStringArray[0]) == 0) {
                    this.currentStep++
                    return "Class set to $inputStringArray[0]"
                } else {
                    return "Class not found."
                }
            }
            else -> "error"
        }
    }
}
