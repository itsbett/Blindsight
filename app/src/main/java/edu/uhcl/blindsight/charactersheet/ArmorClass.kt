package edu.uhcl.blindsight.charactersheet

class ArmorClass {
    var value: Int
    var armorValue: Int
    var additionalValues: Int

    constructor(value: Int, armorValue: Int, additionalValues: Int) {
        this.value = value
        this.armorValue = armorValue
        this.additionalValues = additionalValues
    }
    override fun toString(): String {
        return ("Current AC Value: $value")
    }

}