package edu.uhcl.blindsight.charactersheet

class SavingThrow {
    var additionalValues: Int
    var value: Int
    var name: String
    var proficient: Boolean

    constructor(name: String, value: Int, additionalValues: Int, proficient: Boolean){
        this.name = name
        this.value = value
        this.additionalValues = additionalValues
        this.proficient = proficient
    }
}