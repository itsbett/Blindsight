package edu.uhcl.blindsight.charactersheet

class ArmorClass(var value: Int, var armorValue: Int, var additionalValues: Int) {

    override fun toString(): String {
        return ("Current AC Value: $value")
    }

}