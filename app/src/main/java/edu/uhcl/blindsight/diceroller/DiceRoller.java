package edu.uhcl.blindsight.diceroller;

import org.jetbrains.annotations.NotNull;

public class DiceRoller {

    public int roll(@NotNull String str) {
        if (StringToDiceRollSyntax.hasCorrectSyntax(str)) { // checks syntax
            return StringToDiceRoll.eval(str); // Parses and computes mathematics
        } else {
            throw new IllegalArgumentException(
                    "Illegal character(s)! Allowed chars: 0-9,*,/,-,+,d,(,),sqrt,cos,sin,tan");
        }
    }

    public int rollDropLowest(@NotNull String dice, int nrolls) {
        if (StringToDiceRollSyntax.hasCorrectSyntax(dice)) { // checks syntax
            int roll;
            int min = StringToDiceRoll.eval(dice);
            int sum = 0;

            for (int i = 0; i < (nrolls - 1); i++) {
                roll = StringToDiceRoll.eval(dice);
                if (roll > min) {
                    sum += roll; // Parses and computes mathematics
                } else {
                    sum += min;
                    min = roll;
                }
            }
            return sum;
        } else {
            throw new IllegalArgumentException(
                    "Illegal character(s)! Allowed chars: 0-9,*,/,-,+,d,(,),sqrt,cos,sin,tan");
        }

    }
}
