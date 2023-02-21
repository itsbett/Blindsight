package edu.uhcl.blindsight.charactersheet

class Spell(
    var spellname: String,
    var school: String,
    var spellDescription: String,
    var DiceToRoll: String,
    var castingTime: String,
    var Duration: String,
    var range: String,
    var componets: String,
    var spellLevel: Int,
    var canUpcast: Boolean,
    var upcast: String
) {

}