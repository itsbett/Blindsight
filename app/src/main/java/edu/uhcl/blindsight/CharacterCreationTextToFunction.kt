package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.CharacterManager
import java.util.*

class CharacterCreationTextToFunction(private var characterManager: CharacterManager) {
    private var currentStep: String = "CHOOSE_RACE"

    private fun wordList(line: String): Array<String?> {
        return line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }

    fun readText(input: String): String {
        var inputString = input
        inputString = inputString.uppercase(Locale.getDefault()) //Converts the string to all uppercase for better recognition
        val inputStringArray = wordList(inputString) //Assigns inputString into a String array
        return when(currentStep) {

            "CHOOSE_RACE" ->
            {
                if (inputStringArray[0]?.let { characterManager.setRace(it) } == 0) {
                    this.currentStep = "CHOOSE_CLASS"
                    return "Race set to $inputStringArray[0]"
                } else {
                    return "Race not found."
                }
            }

            "CHOOSE_HEIGHT" ->
            {
                if (inputStringArray[0]?.let { characterManager.setHeight(it) } == 0) {
                    this.currentStep = "CHOOSE_WEIGHT"
                    return "Height set to $inputStringArray[0]"
                } else {
                    return "Height could not be set"
                }
            }

            "CHOOSE_WEIGHT" ->
            {
                if (inputStringArray[0]?.let { characterManager.setWeight(it) } == 0) {
                    this.currentStep = "CHOOSE_NAME"
                    return "Weight set to $inputStringArray[0]"
                } else {
                    return "Weight could not be set."
                }
            }

            "CHOOSE_NAME" ->
            {
                if (inputStringArray[0]?.let { characterManager.setClass(it) } == 0) {
                    this.currentStep = "CHOOSE_GENDER"
                    return "Class set to $inputStringArray[0]"
                } else {
                    return "Class not found."
                }
            }
            "CHOOSE_GENDER" ->
            {
                return "Placeholder"
            }
            "CHOOSE_PHYSICAL_DESCRIPTION" ->
            {
                return "Placeholder"
            }
            "CHOOSE_BACKGROUND" ->
            {
                return "Placeholder"
            }
            "CHOOSE_ALIGNMENT" ->
            {
                return "Placeholder"
            }
            "CHOOSE_ABILITY_SCORE_METHOD" ->
            {
                return "Placeholder"
            }
            "ALLOCATE_ABILITY_SCORES" ->
            {
                return "Placeholder"
            }
            "ALLOCATE_ABILITY_SCORES_CUSTOM" ->
            {
                //ToDo: Calculate modifiers; set Initiative to Dex Mod
                return "Placeholder"
            }
            "CHOOSE_CLASS" ->
            {
                if (inputStringArray[0]?.let { characterManager.setClass(it) } == 0) {
                    this.currentStep = "CHOOSE_HEIGHT"
                    return "Class set to $inputStringArray[0]"
                } else {
                    return "Class not found."
                }
            }
            "CHOOSE_STARTING_EQUIPMENT" ->
            {
                return "Placeholder"
            }
            "SAVE_CHARACTER" ->
            {
                //ToDo: Update saving throws; update proficiencies; set armor class
                return "Placeholder"
            }
            else -> "error"
        }
    }
}
