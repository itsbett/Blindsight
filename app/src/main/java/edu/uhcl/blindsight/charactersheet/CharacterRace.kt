package edu.uhcl.blindsight.charactersheet

data class CharacterRace(
    var raceName: String = "",
    var abilityBonuses: ArrayList<String> = ArrayList<String>(),
    var speed: Int,
    var size: Char,
    var spellAbility: String,
    var featAtCreation: Boolean,
    var proficiencyAtCreation: String,
    var racialTraits: ArrayList<String> = ArrayList<String>()
)
