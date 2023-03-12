package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.*

class CharacterBuildingInformation {
    var characterClasses = hashMapOf<String, CharacterClass>()
    var characterRaces = hashMapOf<String, CharacterRace>()

    public fun generateAllData() {
        generateRaces()
        generateCharacterClasses()
    }
    public fun generateCharacterClasses() {
        var fighter = CharacterClass();
        fighter.className = "Fighter";
        fighter.classHP = "1d10";
        fighter.equipmentChoices = arrayOf(
            arrayOf("chain mail", "leather, longbow, and 20 arrows"),
            arrayOf("martial weapon and shield", "two martial weapons"),
            arrayOf("A light crossbow and 20 bolts", "two handaxes"),
            arrayOf("A dungeoneer's pack", "explorer's pack"))
        fighter.levelUpSheet = "Fighting Style, Second Wind"
        characterClasses["FIGHTER"] = fighter

        var wizard = CharacterClass();
        wizard.className = "Wizard";
        wizard.classHP = "1d6";
        wizard.equipmentChoices = arrayOf(
            arrayOf("quarterstaff", "dagger"),
            arrayOf("component pouch", "arcane focus"),
            arrayOf("scholar's pack", "explorer's pack"),
            arrayOf("spellbook"))
        wizard.levelUpSheet = "Spellcasting, Arcane Recovery"
        characterClasses["WIZARD"] = wizard

        var rogue = CharacterClass();
        rogue.className = "Rogue";
        rogue.classHP = "1d8";
        rogue.equipmentChoices = arrayOf(
            arrayOf("rapier", "short sword"),
            arrayOf("shortbow and quiver of 20 arrows", "shortsword"),
            arrayOf("burglar's pack", "dungeoneer's pack", "explorer's pack"),
            arrayOf("Leather armor, two daggers, and thieves' tools"))
        rogue.levelUpSheet = "Expertise, Sneak Attack, Thieves' Cant"
        characterClasses["ROGUE"] = rogue
        }

    public fun generateRaces() {
        var human = CharacterRace(
            "Human",
            arrayListOf("Strength+1",
                "Dexterity+1",
                "Constitution+1",
                "Intelligence+1",
                "Wisdom+1",
                "Charisma+!"))
        characterRaces["HUMAN"] = human

        var elf = CharacterRace(
            "Elf",
            arrayListOf("Dexterity+2",
                "Darkvision",
                "Keen Senses",
                "Fey Ancestry",
                "Trance"))
        characterRaces["ELF"] = elf

        var dwarf = CharacterRace(
            "Dwarf",
            arrayListOf("Constitution+2",
                "Darkvision",
                "Dwarven Resilience",
                "Dwaren Combat Training",
                "Stonecutting"))
        characterRaces["DWARF"] = dwarf
    }
}