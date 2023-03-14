package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.CharacterManager
import java.util.*

class CharacterCreationTextToFunction(private var characterManager: CharacterManager) {
    private var currentStep: String = "CHOOSE_RACE"
    private lateinit var stats: IntArray
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
                if (inputStringArray[0]?.let { characterManager.setName(it) } == 0) {
                    this.currentStep = "CHOOSE_GENDER"
                    return "Name set to $inputStringArray[0]"
                } else {
                    return "Name not set."
                }
            }

            "CHOOSE_GENDER" ->
            {
                if (inputStringArray[0]?.let { characterManager.setGender(it) } == 0) {
                    this.currentStep = "CHOOSE_PHYSICAL_DESCRIPTION"
                    return "Gender set to $inputStringArray[0]"
                } else {
                    return "Gender not set."
                }
            }
            "CHOOSE_PHYSICAL_DESCRIPTION" ->
            {
                if (inputStringArray[0]?.let { characterManager.setPhysicalDescription(it) } == 0) {
                    this.currentStep = "CHOOSE_BACKGROUND"
                    return "Physical description set to $inputStringArray[0]"
                } else {
                    return "Physical description not set."
                }
            }
            "CHOOSE_BACKGROUND" ->
            {
                if (inputStringArray[0]?.let { characterManager.setBackground(it) } == 0) {
                    this.currentStep = "CHOOSE_ALIGNMENT"
                    return "Background set to $inputStringArray[0]"
                } else {
                    return "Background not found."
                }
            }
            "CHOOSE_ALIGNMENT" ->
            {
                if (inputStringArray[0]?.let { characterManager.setAlignment(it) } == 0) {
                    this.currentStep = "CHOOSE_GENDER"
                    return "Alignment set to $inputStringArray[0]"
                } else {
                    return "Alignment not set."
                }
            }

            "CHOOSE_ABILITY_SCORE_METHOD" ->
            {
                if (inputStringArray.contains("standard") || inputStringArray.contains("array")) {
                    this.stats = characterManager.standardArrayForStats()
                    this.currentStep = "ALLOCATE_ABILITY_SCORES_STANDARD_ARRAY"
                    return "Using Standard Array. What stat do you want to be fifteen?"
                } else if (inputStringArray.contains("point") || inputStringArray.contains("buy")) {
                    this.stats = characterManager.pointBuy()
                    this.currentStep = "ALLOCATE_ABILITY_SCORES_POINT_BUY"
                    return "Using Point Buy system. Please finish coding me."
                } else if (inputStringArray.contains("roll") || inputStringArray.contains("random")) {
                    this.stats = characterManager.rollForStats()
                    this.currentStep = "ALLOCATE_ABILITY_SCORES_ROLL"
                    return "Rolling for stats. You rolled the following: ${this.stats[0]}, ${this.stats[1]}, ${this.stats[2]}," +
                            "${this.stats[3]}, ${this.stats[4]}, and ${this.stats[5]}"
                } else if (inputStringArray.contains("custom") || inputStringArray.contains("choose")) {
                    //ToDo: Point to a loop where they can choose stats.
                    this.currentStep = "ALLOCATE_ABILITY_SCORES_CUSTOM"
                    return "Using custom assignment for stats."
                } else {
                    return "Was not able to pick method."
                }
            }
            "ALLOCATE_ABILITY_SCORES_STANDARD_ARRAY" ->
            {
                //ToDo: give stat name to assign stat array
                return "Placeholder"
            }
            "ALLOCATE_ABILITY_SCORES_POINT_BUY" ->
            {
                //ToDo: Create elaborate system to point buy
                return "Placeholder"
            }
            "ALLOCATE_ABILITY_SCORES_ROLL" ->
            {
                //ToDo: ask which stat they want to assign number to, starting from highest to lowest
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
