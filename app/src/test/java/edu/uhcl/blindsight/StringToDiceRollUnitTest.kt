package edu.uhcl.blindsight

import edu.uhcl.blindsight.diceroller.DiceRoller
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class StringToDiceRollUnitTest {
    private var diceRoller = DiceRoller()
    @Test
    fun multipleSameDice_isCorrect() {
        assertEquals(true, diceRoller.roll("10d2") in 10..20)
    }
    @Test
    fun multipleDifferentDice_isCorrect() {
        assertEquals(true, diceRoller.roll("1d4+1d6+2d20") in 4 .. 50)
    }
    @Test
    fun multiplyNumberOfDice_isCorrect() {
        assertEquals(true, diceRoller.roll("(4*3)d4") in 12 .. 48)
    }
    @Test
    fun addToDice_isCorrect() {
        assertEquals(true, diceRoller.roll("1d2+30") in 31 .. 32)
    }

    @Test
    fun subtractFromDice_isCorrect() {
        assertEquals(true, diceRoller.roll("1d2-1") in 0 .. 1)
    }

}