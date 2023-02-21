package edu.uhcl.blindsight

import edu.uhcl.blindsight.charactersheet.Spell

class Driver {
    val spellList = generateSpellList();

    private fun generateSpellList(): HashMap<String, Spell> {
        val spellList = hashMapOf<String, Spell>()

        return spellList
    }

}