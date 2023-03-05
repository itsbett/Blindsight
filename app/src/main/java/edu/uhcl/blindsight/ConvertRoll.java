package edu.uhcl.blindsight;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class ConvertRoll {

    public static String convertRoll (String string) {
        String rollString = string;
        rollString = rollString.replaceAll("ROLL ", "");

        HashMap<String,String> stringToNum = new HashMap<>();
        stringToNum.put("ONE", "1");
        stringToNum.put("TWO", "2");
        stringToNum.put("THREE", "3");
        stringToNum.put("FOUR", "4");
        stringToNum.put("FIVE", "5");
        stringToNum.put("SIX", "6");
        stringToNum.put("SEVEN", "7");
        stringToNum.put("EIGHT", "8");
        stringToNum.put("NINE", "9");
        stringToNum.put("TEN", "10");
        stringToNum.put("ELEVEN", "11");
        stringToNum.put("TWELVE", "12");
        stringToNum.put("THIRTEEN", "13");
        stringToNum.put("FOURTEEN", "14");
        stringToNum.put("FIFTEEN", "15");
        stringToNum.put("SIXTEEN", "16");
        stringToNum.put("SEVENTEEN", "17");
        stringToNum.put("EIGHTEEN", "18");
        stringToNum.put("NINETEEN", "19");
        stringToNum.put("TWENTY", "20");
        stringToNum.put("PLUS", "+");
        stringToNum.put("MINUS", "-");

        for (String word : stringToNum.keySet()) {
            if (rollString.contains(word)) {
                rollString = rollString.replace(word, Objects.requireNonNull(stringToNum.get(word)));
            }
        }

        rollString = rollString.replaceAll("\\s", "");
        rollString = rollString.toLowerCase();

        return rollString;


    }
}
