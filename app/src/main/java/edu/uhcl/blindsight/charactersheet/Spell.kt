package edu.uhcl.blindsight.charactersheet

data class SpellItem(
    val casting_time: String,
    val classes: List<String>,
    val components: Components,
    val description: String,
    val duration: String,
    val higher_levels: String,
    val level: String,
    val name: String,
    val range: String,
    val ritual: Boolean,
    val school: String,
    val tags: List<String>,
    val type: String
)

data class Components(
    val material: Boolean,
    val materials_needed: List<String>,
    val raw: String,
    val somatic: Boolean,
    val verbal: Boolean
)