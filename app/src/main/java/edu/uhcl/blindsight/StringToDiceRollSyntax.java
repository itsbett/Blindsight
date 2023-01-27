package edu.uhcl.blindsight;

public class StringToDiceRollSyntax {
    /*
     * List of acceptable syntax
     * Includes: 0-9, d, +, -, *, /, ^, (, )
     */
    static boolean[] syntax = new boolean[128];
    static {
        syntax['0'] = true;
        syntax['1'] = true;
        syntax['2'] = true;
        syntax['3'] = true;
        syntax['4'] = true;
        syntax['5'] = true;
        syntax['6'] = true;
        syntax['7'] = true;
        syntax['8'] = true;
        syntax['9'] = true;
        syntax['d'] = true;
        syntax['+'] = true;
        syntax['-'] = true;
        syntax['*'] = true;
        syntax['/'] = true;
        syntax['^'] = true;
        syntax['('] = true;
        syntax[')'] = true;
    }
    /*
     * Recursive loop that compares each character in string against syntax list
     */
    static boolean hasCorrectSyntax(String str) {
        if (str.length()==0) {
            return true;
        }
        char ch = str.charAt(0);
        if (syntax[ch]) {
            return hasCorrectSyntax(str.substring(1));
        } else {
            return false;
        }
    }
}
