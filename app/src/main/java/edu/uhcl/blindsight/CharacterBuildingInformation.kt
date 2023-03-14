package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.*

class CharacterBuildingInformation {
    var characterClasses = hashMapOf<String, CharacterClass>()
    var characterRaces = hashMapOf<String, CharacterRace>()
    var characterBackgrounds = hashMapOf<String, CharacterBackground>()
    public fun generateAllData() {
        generateRaces()
        generateCharacterClasses()
        generateBackgrounds()
    }
    public fun generateCharacterClasses() {
        val fighter = CharacterClass();
        fighter.className = "Fighter";
        fighter.classHP = "1d10";
        fighter.equipmentChoices = arrayOf(
            arrayOf("chain mail", "leather, longbow, and 20 arrows"),
            arrayOf("martial weapon and shield", "two martial weapons"),
            arrayOf("A light crossbow and 20 bolts", "two handaxes"),
            arrayOf("A dungeoneer's pack", "explorer's pack"))
        fighter.levelUpSheet = "Fighting Style, Second Wind"
        characterClasses["FIGHTER"] = fighter

        val wizard = CharacterClass();
        wizard.className = "Wizard";
        wizard.classHP = "1d6";
        wizard.equipmentChoices = arrayOf(
            arrayOf("quarterstaff", "dagger"),
            arrayOf("component pouch", "arcane focus"),
            arrayOf("scholar's pack", "explorer's pack"),
            arrayOf("spellbook"))
        wizard.levelUpSheet = "Spellcasting, Arcane Recovery"
        characterClasses["WIZARD"] = wizard

        val rogue = CharacterClass();
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
        val human = CharacterRace(
            "Dwarf",
            arrayListOf(
                "Strength+1",
                "Dexterity+1",
                "Constitution+1",
                "Intelligence+1",
                "Wisdom+1",
                "Charisma+1"
            ),
            30,
            'M',
            "?",
            false,
            "Common",
            arrayListOf(
                ""
            )

        )
        characterRaces["HUMAN"] = human

        val elf = CharacterRace(
            "Dwarf",
            arrayListOf("Dexterity+2"),
            30,
            'M',
            "?",
            false,
            "Common, Elven",
            arrayListOf(
                "Darkvision",
                "Fey Ancestory",
                "Trance",
                "Keen Senses",
            )
        )
        characterRaces["ELF"] = elf

        val dwarf = CharacterRace(
            "Dwarf",
            arrayListOf("Constitution+2"),
            25,
            'M',
            "?",
            false,
            "?",
            arrayListOf(
            "Darkvision",
            "Dwarven Resilience",
            "Dwarven Combat Training",
            "Stonecutting")
        )
        characterRaces["DWARF"] = dwarf
    }
    public fun generateBackgrounds() {
        val acolyte = CharacterBackground(
            "Acolyte",
            arrayListOf("Any", "Any"),
            arrayListOf(),
            arrayListOf("Insight", "Religion"),
            arrayListOf("holy symbol", "prayer book", "5 sticks of incense",
            "vestments", "common clothes", "15gp"),
            arrayListOf(
                "Free healing, care at a temple, shrine, or any other established presence of your faith and though you must have to provide any material components which are highly needed for spells these are can be expectable to receive by you and your adventuring companions.",
                "At a modest life style, those who share your religion will support only you.",
                "To a specific temple you might have a ties which are dedicated to your chosen deity or pantheon and residence also you have there, so this could be a temple where you have found a new home or where you used to serve.",
                "To get assistance you can call upon the priests and provided the assistance which you ask should not for the hazardous and also you have to remain in the good standing with your temple."
            ),
            arrayListOf(
                "I idolize a particular hero of my faith, and constantly refer to that person's deeds and example."
            ),
            arrayListOf(
                "I judge others harshly, myself even more severely."
            ),
            arrayListOf(
                "Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld. (Lawful)"
            ),
            arrayListOf(
                "I would die to recover an ancient relic of my faith that was lost long ago."
            )
        )
        characterBackgrounds["ACOLYTE"] = acolyte
    }
}