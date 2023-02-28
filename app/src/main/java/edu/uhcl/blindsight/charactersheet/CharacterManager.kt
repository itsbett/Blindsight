package edu.uhcl.blindsight.charactersheet

class CharacterManager {

    constructor() {

    }

    fun createCharacter(): CharacterSheet {
        var newCharacterSheet = CharacterSheet()
        chooseRace(newCharacterSheet)
        return newCharacterSheet;
    }

    private fun chooseRace(newCharacterSheet: CharacterSheet) {
        /*
        @TODO: Insert code that gives player a choice.
        Race should probably be a class that contains modifiers for the charactersheet.
         */
         newCharacterSheet.race = "Human"
    }

    private fun chooseClass(newCharacterSheet: CharacterSheet) {
        /*
        @TODO: Insert code that gives player a choice.
         */
    }
}