package edu.uhcl.blindsight.charactersheet

class Attribute {
    var additionalValues: Int
    var modifier: Int = 0
        get() = (this.value - 10)/2
    var value: Int
    var name: String

    constructor (name: String, value: Int, modifier: Int, additionalValues: Int) {
        this.name = name
        this.value = value
        this.modifier = modifier
        this.additionalValues = additionalValues
    }

}

class Spell {
    var spellname: String
    var school: String
    var spellDescription: String
    var DiceToRoll: String
    var castingTime: String
    var Duration: String
    var range: String
    var componets: String
    var spellLevel: Int
    var canUpcast: Boolean
    var upcast: String

    constructor (spellname: String, school: String, spellDescription: String, DiceToRoll: String, castingTime: String, Duration: String, range: String, componets: String, spellLevel: Int, canUpcast: Boolean, upcast: String) {
        this.spellname = spellname
        this.school = school
        this.spellDescription = spellDescription
        this.DiceToRoll = DiceToRoll
        this.castingTime = castingTime
        this.Duration = Duration
        this.range = range
        this.componets = componets
        this.spellLevel = spellLevel
        this.canUpcast = canUpcast
        this.upcast = upcast

    }
}