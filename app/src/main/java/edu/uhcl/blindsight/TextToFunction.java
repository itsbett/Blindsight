package edu.uhcl.blindsight;
import java.util.Arrays;

public class TextToFunction {

    public static String inputString;

    public TextToFunction(String input) {
        //Constructor class, assigns input parameter to inputString variable
        inputString = input;
    }

    public static String[] wordList(String line) {
        return line.split(" ");                           //Splits the inputString into separate words to be placed in an array
    }

    public static void main(String[] args) {
        inputString = inputString.toUpperCase();                //Converts the string to all uppercase for better recognition

        String[] inputStringArray = wordList(inputString);      //Assigns inputString into a String array

        //Most of these statements check for the first word in the given command.
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
