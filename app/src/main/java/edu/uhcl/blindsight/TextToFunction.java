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

    //This method pulls the attribute from the input string and returns the attribute
    public static String getAttributeFromString(String[] x) {
        String[] attributes = new String[]{"STRENGTH", "DEXTERITY", "CONSTITUTION", "INTELLIGENCE", "WISDOM", "CHARISMA"};
        for (String word : attributes) {
            if (Arrays.asList(x).contains(word)) {
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
    public static void main(String[] args) {
        inputString = inputString.toUpperCase();                //Converts the string to all uppercase for better recognition

        String[] inputStringArray = wordList(inputString);      //Assigns inputString into a String array

        //Most of these statements check for the first word in the given command.
        if (inputStringArray[0].equals("ROLL")) {
            //Roll a die function
            if (Arrays.asList(inputStringArray).contains("D[0-9]")) {
                //Roll natural dice
            }
            //If the string contains 'Saving' and 'Throw', then get the attribute from the string and execute the correct saving throw method
            else if (Arrays.asList(inputStringArray).contains("SAVING") && Arrays.asList(inputStringArray).contains("THROW")) {
                String attributeToRoll = getAttributeFromString(inputStringArray);
                    //characterSheet.SavingThrows[attributeToRoll].roll();
                }
            }
        //If the string contains 'CHECK', then check if the string contains an attribute
        else if (Arrays.asList(inputStringArray).contains("CHECK")) {
            String attributeToRoll = getAttributeFromString(inputStringArray);

            //If the string is not 'NONE', then roll the corresponding check
            if (!attributeToRoll.equals("NONE")) {
                //characterSheet.abilityChecks[attributeToRoll].roll();
            }

            //If the string doesn't contain an attribute, then roll a skill check
            else {
                String skillToRoll = getSkillFromString(inputStringArray);
                //characterSheet.skillChecks[skillToRoll].roll();
            }
        }

        //If the string contains "ATTACK", roll a weapon attack
        else if (Arrays.asList(inputStringArray).contains("ATTACK")) {
            //Attack with a weapon function
        }

        //If the string starts with "CAST", cast a spell
        else if (inputStringArray[0].equals("CAST")) {
            //Cast a spell function
        }

        //If the string contains "REMOVE" and "HP" OR "TAKE" and "DAMAGE", then remove HP
        else if ((inputStringArray[0].equals("REMOVE") && Arrays.asList(inputStringArray).contains("HP")) ||
                (Arrays.asList(inputStringArray).contains("TAKE") && Arrays.asList(inputStringArray).contains("DAMAGE"))) {
            int hpNum = getNumFromString(inputStringArray);
            if (hpNum == -1) {
                //Unrecognized number
            }
            else {
                //Remove HP function
            }
        }

        //If the string contains "ADD" or "HEAL", then add HP
        else if (inputStringArray[0].equals("ADD") || Arrays.asList(inputStringArray).contains("HEAL")) {
            int hpNum = getNumFromString(inputStringArray);
            if (hpNum == -1) {
                //Unrecognized number
            }
            else {
                //Add HP function
            }
        }

        //If the string contains "LONG" and "REST", then complete a long rest
        else if (Arrays.asList(inputStringArray).contains("LONG") && Arrays.asList(inputStringArray).contains("REST")) {
            //Long Rest function
        }

        else {
            //Unrecognized command
        }
    }
}

