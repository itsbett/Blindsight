package edu.uhcl.blindsight;

public class DiceRoller {
    public static int roll(String str) {
        if (StringToDiceRollSyntax.hasCorrectSyntax(str)) { // checks syntax
            return StringToDiceRoll.eval(str); // Parses and computes mathematics
        } else {
            throw new IllegalArgumentException(
                    "Illegal character(s)! Allowed chars: 0-9,*,/,-,+,d,(,),sqrt,cos,sin,tan");
        }
    }
}
