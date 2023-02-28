package edu.uhcl.blindsight

import android.app.Application
import edu.uhcl.blindsight.charactersheet.Spell
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper


class Driver {

    private fun generateSpellList(): HashMap<String, Spell> {
        val spellList = hashMapOf<String, Spell>()
        val file = "raw/spells.json"
        val am = Application().assets.open("spells.json");

        return spellList
    }

    fun getSpell () {
        val json = """{"name":"Endgame","studio":"Marvel","rating":9.2}"""
        val mapper = jacksonObjectMapper()
       // val spellList: List<Spell> = mapper.readValue()
        val aMap: Map<String, String> = mapper.readValue(json)

        println(aMap["name"])

    }
}