package edu.uhcl.blindsight.charactersheet


fun main () {
    println("Life is pain")
    var strength = Attribute("Strength", 18, 0, 0);
    println("Your modifier is " + strength.modifier + " and its value is " + strength.value)
    var spell = Spell("Magic Missle", "cat", "GUD", "4", "10 hours", "1 min",
        "all the range", "everything", 99, true, "maybe")
    println("Your spell " + spell.spellname + " " + "Dice to roll is " + spell.DiceToRoll)
}