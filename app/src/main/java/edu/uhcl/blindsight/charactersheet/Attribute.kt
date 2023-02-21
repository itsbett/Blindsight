package edu.uhcl.blindsight.charactersheet


class Attribute(var name: String, var value: Int, var additionalValues: Int) {
    val modifier: Int
        get() = (this.value - 10)/2
}