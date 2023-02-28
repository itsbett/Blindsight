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
                switch (attributeToRoll) {
                    case "STRENGTH":
                        //Roll Strength Saving Throw
                        break;
                    case "DEXTERITY":
                        //Roll Dexterity Saving Throw
                        break;
                    case "CONSTITUTION":
                        //Roll Constitution Saving Throw
                        break;
                    case "INTELLIGENCE":
                        //Roll Intelligence Saving Throw
                        break;
                    case "WISDOM":
                        //Roll Wisdom Saving Throw
                        break;
                    case "CHARISMA":
                        //Roll Charisma Saving Throw
                        break;
                }
            }
            //If the string contains 'CHECK', then check if the string contains an attribute
            else if (Arrays.asList(inputStringArray).contains("CHECK")) {
                String attributeToRoll = getAttributeFromString(inputStringArray);

                //If the string is not 'NONE', then roll the corresponding check
                if (!attributeToRoll.equals("NONE")) {
                    switch (attributeToRoll) {
                        case "STRENGTH":
                            //Roll Strength Check
                            break;
                        case "DEXTERITY":
                            //Roll Dexterity Check
                            break;
                        case "CONSTITUTION":
                            //Roll Constitution Check
                            break;
                        case "INTELLIGENCE":
                            //Roll Intelligence Check
                            break;
                        case "WISDOM":
                            //Roll Wisdom Saving Check
                            break;
                        case "CHARISMA":
                            //Roll Charisma Saving Check
                            break;
                    }
                }
                //Roll a skill check
                else {
                    String skillToRoll = getSkillFromString(inputStringArray);
                    switch (skillToRoll) {
                        case "ACROBATICS":
                            //Roll Acrobatics Check
                            break;
                        case "ANIMAL HANDLING":
                            //Roll Animal Handling Check
                            break;
                        case "ARCANA":
                            //Roll Arcana check
                            break;
                        //ETC
                    }
                }
            } else if (inputStringArray[0].equals("ATTACK")) {
                //Attack with a weapon function
            } else if (inputStringArray[0].equals("CAST")) {
                //Cast a spell function
            } else if (inputStringArray[0].equals("REMOVE")) {
                //Remove HP function
            } else if (inputStringArray[0].equals("ADD")) {
                //Add HP function
            } else if (Arrays.asList(inputStringArray).contains("LONG") && Arrays.asList(inputStringArray).contains("REST")) {
                //Long Rest function
            }
        }
    }
}
