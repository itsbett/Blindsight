package edu.uhcl.blindsight.charactersheet

fun main () {
    var strength = Attribute("Strength", 18, 0)
    println("Your skill is is " + strength.name + "\nIt's modifier is "+ strength.modifier + "\nand its value is " + strength.value)

    var dexterity = Attribute("Dexterity", 18, 0)
    println("Your skill is is " + dexterity.name + "\nIt's modifier is "+ dexterity.modifier + "\nand its value is " + dexterity.value)

    var constitution = Attribute("Constitution", 18, 0);
    println("Your skill is is " + constitution.name + "\nIt's modifier is "+ constitution.modifier + "\nand its value is " + constitution.value)

    var intelligence = Attribute("Intelligence", 18, 0);
    println("Your skill is is " + intelligence.name + "\nIt's modifier is "+ intelligence.modifier + "\nand its value is " + intelligence.value)

    var wisdom = Attribute("Wisdom", 18, 0);
    println("Your skill is is " + wisdom.name + "\nIt's modifier is "+ wisdom.modifier + "\nand its value is " + wisdom.value)

    var charisma = Attribute("Charisma", 18, 0);
    println("Your skill is is " + charisma.name + "\nIt's modifier is "+ charisma.modifier + "\nand its value is " + charisma.value)
}