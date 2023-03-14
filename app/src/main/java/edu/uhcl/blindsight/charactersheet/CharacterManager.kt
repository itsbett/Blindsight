package edu.uhcl.blindsight.charactersheet

import edu.uhcl.blindsight.CharacterBuildingInformation
import edu.uhcl.blindsight.TextToFunction
import edu.uhcl.blindsight.diceroller.DiceRoller

class CharacterManager() {
    lateinit var currentCharacterSheet: CharacterSheet
    val textToFunction: TextToFunction = TextToFunction()
    val diceRoller: DiceRoller = DiceRoller()
    private val characterBuildingInformation = CharacterBuildingInformation()

    init {
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

    public fun setClass(className: String): Int {
        val characterClasses = characterBuildingInformation.characterClasses
        if (characterClasses.containsKey(className)) {
            currentCharacterSheet.characterClass = characterClasses[className]!!
            return 0
        } else {
            return 1
        }
    }

    public fun setRace(raceName: String): Int {
        val characterRaces = characterBuildingInformation.characterRaces
        if (characterRaces.containsKey(raceName)) {
            currentCharacterSheet.race = characterRaces[raceName]!!
            return 0
        } else {
            return 1
        }
    }

    public fun setHeight(height: String): Int {
        currentCharacterSheet.height = height;
        return 0
    }
    public fun setWeight(weight: String): Int {
        currentCharacterSheet.height = weight;
        return 0
    }
    public fun setBackground (backgroundName: String): Int {
        val characterBackgrounds = characterBuildingInformation.characterBackgrounds
        if (characterBackgrounds.containsKey(backgroundName)) {
            currentCharacterSheet.characterBackground = characterBackgrounds[backgroundName]!!
            return 0
        } else {
            return 1
        }
    }

    public fun setAlignment (alignment: String): Int {
        currentCharacterSheet.alignment = alignment
        return 0
    }

    public fun rollForStats(): IntArray {
        return intArrayOf(
            diceRoller.rollDropLowest("1d6", 4),
            diceRoller.rollDropLowest("1d6", 4),
            diceRoller.rollDropLowest("1d6", 4),
            diceRoller.rollDropLowest("1d6", 4),
            diceRoller.rollDropLowest("1d6", 4),
            diceRoller.rollDropLowest("1d6", 4),
        )
    }

    public fun standardArrayForStats(): IntArray {
        return intArrayOf(15, 14, 13, 12, 10, 8)
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