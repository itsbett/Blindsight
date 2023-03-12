package edu.uhcl.blindsight.charactersheet

class CharacterManager {
    lateinit var currentCharacterSheet: CharacterSheet

    constructor() {

    }

    /**
     * This creates a new character that will immediately go through the character creation
     * process.
     *@return Returns the New Character sheet, likely to be added to the Account.
     */
    fun createCharacter(): CharacterSheet {
        var newCharacterSheet = CharacterSheet()
        this.currentCharacterSheet = newCharacterSheet
        chooseRace(newCharacterSheet)
        return newCharacterSheet;
    }

    private fun chooseRace(newCharacterSheet: CharacterSheet) {
        /*
        @TODO: Insert code that gives player a choice.
        Race should probably be a class that contains modifiers for the charactersheet.
         */
         currentCharacterSheet.race = "Human"
    }

    private fun chooseClass(newCharacterSheet: CharacterSheet) {
        /*
        @TODO: Insert code that gives player a choice.
         */
        currentCharacterSheet.characterClass.className = "Fighter"
        currentCharacterSheet.characterClass.classHP = "1d10"
        currentCharacterSheet.characterClass.
    }

    private fun chooseHeightAndWeight() {
        /*
        @TODO: Allow player to choose height and weight. Make it optional.
         */
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