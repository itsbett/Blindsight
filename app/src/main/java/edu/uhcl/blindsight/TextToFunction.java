package edu.uhcl.blindsight;
import java.util.ArrayList;
import java.util.Arrays;

import edu.uhcl.blindsight.diceroller.StringToDiceRoll;

public class TextToFunction {

    public static String[] wordList(String line) {
        return line.split(" ");                           //Splits the inputString into separate words to be placed in an array
    }

    //This method pulls the attribute from the input string and returns the attribute
    public static String getAttributeFromString(String[] x) {
        String[] attributes = new String[]{"STRENGTH", "DEXTERITY", "CONSTITUTION", "INTELLIGENCE", "WISDOM", "CHARISMA"};
        for (String word : attributes) {
            if (Arrays.asList(x).contains(word)) {
                //return word.charAt(0) + word.substring(1).toLowerCase();
                return word;
            }
        }
        return "NONE";
    }

    //This method pulls the skill from the input string and returns the skill
    public static String getSkillFromString(String[] x) {
        String[] skills = new String[]{"ACROBATICS", "ANIMAL HANDLING", "ARCANA", "ATHLETICS", "DECEPTION", "HISTORY", "INSIGHT", "INTIMIDATION", "INVESTIGATION",
        "MEDICINE", "NATURE", "PERCEPTION", "PERFORMANCE", "PERSUASION", "RELIGION", "SLEIGHT OF HAND", "STEALTH", "SURVIVAL"};
        for (String skill : skills) {
            if (Arrays.asList(x).contains(skill)) {
                return skill;
            }
        }
        return "NONE";
    }

    //This method pulls the number from the input string and returns it
    public static int getNumFromString(String[] x) {
        for (String y : x) {
            try {
                return Integer.parseInt(y);
            } catch (NumberFormatException ignored) {}
        }
        return -1; //Return -1 if there is no number in the string
    }

    //The main method. Takes inputString from the constructor
    public static String readText(String input) {
        String inputString = input;
        inputString = inputString.toUpperCase();                //Converts the string to all uppercase for better recognition

        String[] inputStringArray = wordList(inputString);      //Assigns inputString into a String array

        //Check if the string contains 'Saving' and 'Throw'
        if (Arrays.asList(inputStringArray).contains("SAVING") && Arrays.asList(inputStringArray).contains("THROW")) {
            String attributeToRoll = getAttributeFromString(inputStringArray);
            //characterSheet.SavingThrows[attributeToRoll].roll();
            return "Rolling " + attributeToRoll + " Saving Throw";
        }

        else if (Arrays.asList(inputStringArray).contains("CHECK")) {
            String attributeToRoll = getAttributeFromString(inputStringArray);

            //If the string is not 'NONE', then roll the corresponding check
            if (!attributeToRoll.equals("NONE")) {
                //characterSheet.abilityChecks[attributeToRoll].roll();
                return "Rolling " + attributeToRoll + " Check";
            }

            //If the string doesn't contain an attribute, then roll a skill check
            else {
                String skillToRoll = getSkillFromString(inputStringArray);
                //characterSheet.skillChecks[skillToRoll].roll();
                return "Rolling " + skillToRoll + " Check";
            }
        }
        //If the string contains "ATTACK", roll a weapon attack
        else if (Arrays.asList(inputStringArray).contains("ATTACK")) {
            //Attack with a weapon function
            return "Rolling Attack";
        }
        //If the string starts with "CAST", cast a spell
        else if (inputStringArray[0].equals("CAST")) {
            //Cast a spell function
            return "Casting Spell";
        }
        else if (inputStringArray[0].equals("ROLL")) {
            //Roll a die function
            if (inputString.matches(".*D\\d*") || inputString.matches(".*\\d*D*")) {
                //Roll natural dice
                String convertedString = ConvertRoll.convertRoll(inputString);
                return String.valueOf(StringToDiceRoll.eval(convertedString));
                //return "Rolling Natural Dice";
            } else {
                return "Unrecognized Command";
            }
        }
        //If the string contains "REMOVE" and "HP" OR "TAKE" and "DAMAGE", then remove HP
        else if ((inputStringArray[0].equals("REMOVE") && Arrays.asList(inputStringArray).contains("HP")) ||
                (Arrays.asList(inputStringArray).contains("TAKE") && Arrays.asList(inputStringArray).contains("DAMAGE"))) {
            int hpNum = getNumFromString(inputStringArray);
            if (hpNum == -1) {
                //Unrecognized number
                return "Unrecognized Number";
            }
            else {
                //Remove HP function
                return "Removing HP";
            }
        }
        //If the string contains "ADD" or "HEAL", then add HP
        else if (inputStringArray[0].equals("ADD") || Arrays.asList(inputStringArray).contains("HEAL")) {
            int hpNum = getNumFromString(inputStringArray);
            if (hpNum == -1) {
                //Unrecognized number
                return "Unrecognized Number";
            }
            else {
                //Add HP function
                return "Adding HP";
            }
        }
        //If the string contains "LONG" and "REST", then complete a long rest
        else if (Arrays.asList(inputStringArray).contains("LONG") && Arrays.asList(inputStringArray).contains("REST")) {
            //Long Rest function
            return "Long Rest";
        }

        else if (Arrays.asList(inputStringArray).contains("CREATE") || Arrays.asList(inputStringArray).contains("CREATION")) {
            return "CHARACTER CREATION";
        }

        else {
            //Unrecognized command
            return "Unrecognized Command";
        }
    }
}

