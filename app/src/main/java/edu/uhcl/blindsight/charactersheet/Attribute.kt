package edu.uhcl.blindsight.charactersheet

class Attribute {
    var additionalValues: Int
    var modifier: Int
    var value: Int
    var name: String

    constructor (name: String, value: Int, modifier: Int, additionalValues: Int) {
        this.name = name
        this.value = value
        this.modifier = modifier
        this.additionalValues = additionalValues
    }
}