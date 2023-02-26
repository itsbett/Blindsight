package edu.uhcl.blindsight;
import java.util.Arrays;

public class TextToFunction {

    public static String inputString;

    public TextToFunction(String input) {
        inputString = input;
    }

    public static String[] wordList(String line) {
        return line.split(" ");
    }

    public static void main(String[] args) {
        inputString = inputString.toUpperCase();

        String[] inputStringArray = wordList(inputString);

        if (inputStringArray[0].equals("ROLL")) {
            //Roll a die function
        } else if (inputStringArray[0].equals("ATTACK")){
            //Attack with a weapon function
        } else if (inputStringArray[0].equals("CAST")){
            //Cast a spell function
        } else if (inputStringArray[0].equals("REMOVE")){
            //Remove HP function
        } else if (inputStringArray[0].equals("ADD")){
            //Add HP function
        } else if (Arrays.asList(inputStringArray).contains("LONG") && Arrays.asList(inputStringArray).contains("REST")) {
            //Long Rest function
        }
    }
}
