package edu.uhcl.blindsight.charactersheet

fun main() {
    var athletics = Skill( "Athletics",  2, false,  additionalValues = 0)
    println("Your skill is " + athletics.name + "\nAre you proficient? "+ athletics.proficient + "\nand its value is " + (athletics.value+athletics.additionalValues))
}