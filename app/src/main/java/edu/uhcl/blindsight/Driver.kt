package edu.uhcl.blindsight

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import com.squareup.moshi.Moshi
import edu.uhcl.blindsight.charactersheet.Spell


class Driver {

    val spellList = generateSpellList();

    private fun generateSpellList(): HashMap<String, Spell> {
        val spellList = hashMapOf<String, Spell>()
        val file = "raw/spells.json"
        val am = Application().assets.open("spells.json");
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter<Spell>(Spell::class.java)
        //val spell = adapter.fromJson(spells)
        return spellList
    }
    fun AssetManager.readFile(fileName: String) = open("raw/spells.json").bufferedReader().use {it.readText()}
}