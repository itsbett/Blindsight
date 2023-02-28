package edu.uhcl.blindsight.charactersheet

fun main() {
    var athletics = Skill( "Athletics",  2, false,  additionalValues = 0)
    println("Your skill is " + athletics.name + "\nAre you proficient? "+ athletics.proficient + "\nand its value is " + (athletics.value+athletics.additionalValues))

    var acrobatics = Skill( "Acrobatics",  2, false,  additionalValues = 0)
    println("Your skill is " + acrobatics.name + "\nAre you proficient? "+ acrobatics.proficient + "\nand its value is " + (acrobatics.value+acrobatics.additionalValues))

    var animalhandling = Skill( "Animal Handling",  2, false,  additionalValues = 0)
    println("Your skill is " + animalhandling.name + "\nAre you proficient? "+ animalhandling.proficient + "\nand its value is " + (animalhandling.value + animalhandling.additionalValues))

    var sol = Skill( "Slight of Hand",  2, false,  additionalValues = 0)
    println("Your skill is " + sol.name + "\nAre you proficient? "+ sol.proficient + "\nand its value is " + (sol.value + sol.additionalValues))

    var stealth = Skill( "Stealth",  2, false,  additionalValues = 0)
    println("Your skill is " + stealth.name + "\nAre you proficient? "+ stealth.proficient + "\nand its value is " + (stealth.value + stealth.additionalValues))

    var arcana = Skill( "Arcana",  2, false,  additionalValues = 0)
    println("Your skill is " + arcana.name + "\nAre you proficient? "+ arcana.proficient + "\nand its value is " + (arcana.value + arcana.additionalValues))

    var history = Skill( "History",  2, false,  additionalValues = 0)
    println("Your skill is " + history.name + "\nAre you proficient? "+ history.proficient + "\nand its value is " + (history.value + history.additionalValues))

    var investigation = Skill( "Investigation",  2, false,  additionalValues = 0)
    println("Your skill is " + investigation.name + "\nAre you proficient? "+ investigation.proficient + "\nand its value is " + (investigation.value + investigation.additionalValues))

    var nature = Skill( "Nature",  2, false,  additionalValues = 0)
    println("Your skill is " + nature.name + "\nAre you proficient? "+ nature.proficient + "\nand its value is " + (nature.value + nature.additionalValues))

    var religion = Skill( "Religion",  2, false,  additionalValues = 0)
    println("Your skill is " + religion.name + "\nAre you proficient? "+ religion.proficient + "\nand its value is " + (religion.value + religion.additionalValues))

    var insight = Skill( "Insight",  2, false,  additionalValues = 0)
    println("Your skill is " + insight.name + "\nAre you proficient? "+ insight.proficient + "\nand its value is " + (insight.value + insight.additionalValues))

    var medicine = Skill( "Medicine",  2, false,  additionalValues = 0)
    println("Your skill is " + medicine.name + "\nAre you proficient? "+ medicine.proficient + "\nand its value is " + (medicine.value + medicine.additionalValues))

    var perception = Skill( "Perception",  2, false,  additionalValues = 0)
    println("Your skill is " + perception.name + "\nAre you proficient? "+ perception.proficient + "\nand its value is " + (perception.value + perception.additionalValues))

    var survival = Skill( "Survival",  2, false,  additionalValues = 0)
    println("Your skill is " + survival.name + "\nAre you proficient? "+ survival.proficient + "\nand its value is " + (survival.value + survival.additionalValues))

    var deception = Skill( "Deception",  2, false,  additionalValues = 0)
    println("Your skill is " + deception.name + "\nAre you proficient? "+ deception.proficient + "\nand its value is " + (deception.value + deception.additionalValues))

    var intimidation = Skill( "Intimidation",  2, false,  additionalValues = 0)
    println("Your skill is " + intimidation.name + "\nAre you proficient? "+ intimidation.proficient + "\nand its value is " + (intimidation.value + intimidation.additionalValues))

    var performance = Skill( "Performance",  2, false,  additionalValues = 0)
    println("Your skill is " + performance.name + "\nAre you proficient? "+ performance.proficient + "\nand its value is " + (performance.value + performance.additionalValues))

    var persuasion = Skill( "Persuasion",  2, false,  additionalValues = 0)
    println("Your skill is " + persuasion.name + "\nAre you proficient? "+ persuasion.proficient + "\nand its value is " + (persuasion.value + persuasion.additionalValues))
}