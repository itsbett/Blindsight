package edu.uhcl.blindsight.charactersheet

data class CharacterRace(
    var raceName: String = "",
    var abilityBonuses: ArrayList<String> = ArrayList<String>(),
    var speed: Int = 0,
    var size: Char = '0',
    var spellAbility: String = "",
    var featAtCreation: Boolean = false,
    var proficiencyAtCreation: String = "",
    var racialTraits: ArrayList<String> = ArrayList<String>()
)
