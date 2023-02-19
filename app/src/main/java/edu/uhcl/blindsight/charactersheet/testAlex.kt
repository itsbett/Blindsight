package edu.uhcl.blindsight.charactersheet

fun main () {
    var strengthSavingThrow = SavingThrow("Strength", 5, 0, true)

    println("You have made a saving throw of: " + (strengthSavingThrow.value + strengthSavingThrow.additionalValues))
}