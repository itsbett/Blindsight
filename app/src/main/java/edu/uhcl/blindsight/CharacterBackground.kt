package edu.uhcl.blindsight

data class CharacterBackground (
    var name: String = "",
    var languages: ArrayList<String> = ArrayList<String>(),
    var tools: ArrayList<String> = ArrayList<String>(),
    var skills: ArrayList<String> = ArrayList<String>(),
    var equipment: ArrayList<String> = ArrayList<String>(),
    var fringeBenefits: ArrayList<String> = ArrayList<String>(),
    var personalityTraits: ArrayList<String> = ArrayList<String>(),
    var flaws: ArrayList<String> = ArrayList<String>(),
    var ideals: ArrayList<String> = ArrayList<String>(),
    var bonds: ArrayList<String> = ArrayList<String>(),
)
