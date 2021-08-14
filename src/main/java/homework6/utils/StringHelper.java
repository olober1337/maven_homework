package homework6.utils;

import homework6.exceptions.StringFormatException;

public class StringHelper {

    public String checkStringAndArray(String newString, char[] charArray) throws StringFormatException {

        if (charArray == null) {
            throw new NullPointerException("This array is empty!");
        }

        String charToStringTransform = String.valueOf(charArray);

        if (newString.isEmpty() && charToStringTransform.isEmpty()) {
            throw new StringFormatException("The string is empty");
        }

        newString = newString.toUpperCase();
        charToStringTransform = charToStringTransform.toLowerCase();

        newString = newString.trim();
        charToStringTransform = charToStringTransform.trim();

        newString = newString.concat(" " + charToStringTransform);

        if (newString.length() % 2 != 0) {
            newString = newString.substring(0, newString.length() / 2) + newString.substring(newString.length() / 2 + 1);
            return newString;
        } else {
            newString = newString.substring(0, newString.length() / 2 - 1) + newString.substring(newString.length() / 2 + 1);
        }
        return newString;
    }
}
