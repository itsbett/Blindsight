package edu.uhcl.blindsight;

import java.util.concurrent.ThreadLocalRandom;

public class StringToDiceRoll {
    /*
     * Rolls (dice) amount of dice with (sides). e.g. 2d6 will return a value between 2-12, with 6 being the
     * mean on normal distribution. (What you would expect from rolling two 1d6 dice in the real world)
     */
    public static int roll(int dice, int sides) {
        int total = 0;
        int roll = 0;
        if (sides<=1) {
            throw new IllegalArgumentException("The sides of your dice need more than 1 side!");
        }
        for (int i = 0; i < dice; i++) {
            roll = ThreadLocalRandom.current().nextInt(1, sides+1);
            //System.out.println("Roll: " + i + " You rolled a: " + roll + "!"); //For checking individual rolls
            total = total + roll;
            //System.out.println("Total roll: " + total); //For checking sum of rolls
        }
        return total;
    }

    public static int eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            int parse() {
                nextChar();
                int x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor | term `d` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            int parseExpression() {
                int x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            int parseTerm() {
                int x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else if (eat('d')) x = roll(x, parseFactor()); //roll dice
                    else return x;
                }
            }

            int parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                int x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Integer.parseInt(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = (int) Math.sqrt(x);
                    else if (func.equals("sin")) x = (int) Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = (int) Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = (int) Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = (int) Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
