package edu.uhcl.blindsight.charactersheet

import com.fasterxml.jackson.core.JsonGenerator.Feature

data class CharacterSheet(
    var name: String= "",
    var level: Int = 0,
    var maxHP: Int = 0,
    var currentHP: Int = 69,
    var tempHP: Int = 0,
    var tempMaxHP: Int = 0,
    var experiencePoints: Int = 0,
    var race: String = "",
    var playerName: String = "",
    var alignment: String = "",
    var armorClass: ArmorClass = ArmorClass(0,0,0),
    var deathSave: DeathSave = DeathSave(),

    var attributes: Map<String, Attribute> = emptyMap<String, Attribute>(),
    var featuresAndTraits: Map<String, Feature> = emptyMap<String, Feature>(),
    var savingThrows: Map<String, SavingThrow> = emptyMap<String, SavingThrow>(),
    var skills: Map<String, Skill> = emptyMap<String, Skill>(),
    var knownSpells: Map<String, Spell> = emptyMap<String, Spell>()
)