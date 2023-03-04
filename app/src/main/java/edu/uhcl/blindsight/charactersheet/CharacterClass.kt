package edu.uhcl.blindsight.charactersheet

data class CharacterClass (
    var className: String = "Fighter",
    var classHP: String = "1d10",
    var proficiency: Map<String, String> = emptyMap<String, String>(),
    var equipmentChoices: List<GameItem> = emptyList(),
    var levelUpSheet: List<LevelBenefits> = emptyList()
    )