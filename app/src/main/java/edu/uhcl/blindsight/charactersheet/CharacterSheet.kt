package edu.uhcl.blindsight.charactersheet


import edu.uhcl.blindsight.CharacterBackground

data class CharacterSheet(
    var name: String= "",
    var level: Int = 0,
    var maxHP: Int = 0,
    var currentHP: Int = 69,
    var tempHP: Int = 0,
    var tempMaxHP: Int = 0,
    var experiencePoints: Int = 0,
    var race: CharacterRace = CharacterRace(),
    var playerName: String = "",
    var alignment: String = "",
    var height: String = "",
    var weight: String = "",
    var armorClass: ArmorClass = ArmorClass(0,0,0),
    var deathSave: DeathSave = DeathSave(),
    var characterClass: CharacterClass = CharacterClass(),
    var characterBackground: CharacterBackground = CharacterBackground(),
    var attributes: Map<String, Attribute> = emptyMap<String, Attribute>(),
    var featuresAndTraits: Map<String, FeatOrTrait> = emptyMap<String, FeatOrTrait>(),
    var savingThrows: Map<String, SavingThrow> = emptyMap<String, SavingThrow>(),
    var skills: Map<String, Skill> = emptyMap<String, Skill>(),
    var knownSpells: Map<String, Spell> = emptyMap<String, Spell>()
)