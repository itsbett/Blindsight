package edu.uhcl.blindsight.charactersheet

import edu.uhcl.blindsight.diceroller.DiceRoller

class DeathSave (
    var successes: Int = 0,
    var failures: Int = 0
        )
{
    var diceRoller: DiceRoller = DiceRoller()
    fun rollDeathSave() {
        var deathRoll: Int = diceRoller.roll("1d10")
        if (deathRoll < 10) {
            this.failures++
        } else {
            this.successes++
        }
    }
}
