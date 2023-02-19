package edu.uhcl.blindsight.charactersheet

fun main () {
    var strength = Attribute("Strength", 18, 0);
    println("Your skill is is " + strength.name + "\nIt's modifier is "+ strength.modifier + "\nand its value is " + strength.value)

}