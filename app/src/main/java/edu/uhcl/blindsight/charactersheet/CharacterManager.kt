package edu.uhcl.blindsight.charactersheet

import edu.uhcl.blindsight.CharacterBuildingInformation
import edu.uhcl.blindsight.TextToFunction

class CharacterManager {
    lateinit var currentCharacterSheet: CharacterSheet
    val textToFunction: TextToFunction = TextToFunction()
    private val characterBuildingInformation = CharacterBuildingInformation()
    constructor() {
        characterBuildingInformation.generateAllData()
    }

    /**
     * This creates a new character that will immediately go through the character creation
     * process.
     *@return Returns the New Character sheet, likely to be added to the Account.
     */
    fun createCharacter(): CharacterSheet {
        var newCharacterSheet = CharacterSheet()
        this.currentCharacterSheet = newCharacterSheet
        return newCharacterSheet;
    }

    public fun setClass(className: String): String {
        val characterClasses = characterBuildingInformation.characterClasses
        if (characterClasses.containsKey(className)) {
            currentCharacterSheet.characterClass = characterClasses[className]!!
            return "You have chosen $className as your class."
        } else {
            return "We could not find $className"
        }
    }

    private fun setRace(raceName: String): String {
        val characterRaces = characterBuildingInformation.characterRaces
        if (characterRaces.containsKey(raceName)) {
            currentCharacterSheet.race = characterRaces[raceName]!!
            return "Class set to $raceName"
        } else {
            return "We could not find $raceName"
        }
    }

    private fun chooseRace() {
        /*
        @TODO: Insert code that gives player a choice.
        Race should probably be a class that contains modifiers for the charactersheet.

         currentCharacterSheet.race = "Human"
         */

    }

    private fun chooseClass() {
        /*
        @TODO: Insert code that gives player a choice.
         */

        currentCharacterSheet.characterClass.className = "Fighter";
        currentCharacterSheet.characterClass.classHP = "1d10";

    }

    private fun chooseHeightAndWeight(newCharacterSheet: CharacterSheet) {
        /*
        @TODO: Allow player to choose height and weight. Make it optional.
         */

        print("Would you like to choose height and weight?")

        val hwinput = readLine()!!
        if (hwinput == "yes") {
            print("please enter height: ")
            currentCharacterSheet.height == readLine()!!
            print("please enter weight ")
            currentCharacterSheet.weight = readLine()!!
        }

        else{
        print("ok")
        }
    }

    private fun chooseBackground() {
        /*
        @TODO: Allow them to choose a background or to make a custom one.
         */
    }

    private fun chooseAlignment() {
        /*
        @TODO: Pick alignment.
         */


    }

    private fun determineAbilityScores() {
        /*
        @TODO: Give the player the ability to choose four options to choose stats.
         */
    }

    private fun rollForStats() {
        /*
        @TODO: standard roll 4d6 and drop lowest 6 times, then choose what number goes where.
         */
    }

    private fun staticArrayForStats() {
        /*
        @TODO: Let the
         */
    }

    private fun pointBuyForStats() {
        /*
        @TODO use the point buy system. Probably most complicated.
         */
    }

    private fun customForStats() {
        /*
        @TODO: Easiest. Just declare the stats.
         */

        var strength: Int
        var dexterity: Int
        var constitution: Int
        var intellegence: Int
        var wisdom: Int
        var charisma: Int


    }

    private fun chooseStats() {
        /*
        @TODO: Implement
         */
    }

    private fun calculateModifiers() {
        /*
        @TODO: Should run through the character sheet and update the modifiers.
         */
    }

    private fun saveCharacter() {
        /*
        @TODO: Serialize the character sheet class to be loaded later.
         */
    }

    private fun loadCharacter() {
        /*
        @TODO: Unserialize character sheet.
         */
    }

}