package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {

    /**
     * WS 2-3 PART 1
     * Method returns the signature value of the input string. Character-by-character it evaluates
     * the ASCII values & adds the corresponding T9 key to the StringBuffer. When all the characters
     * in the input word have been examined, it returns whatever is in the StringBuffer.
     * Lowercase & Uppercase characters are both accounted for, non-alphabetic characters send an
     * empty " " in the StringBuffer.
     *
     * @param word the word whose signature value we're looking for
     * @return signature value of the input word
     */
    public static String wordToSignature(String word) {
        word = word.toLowerCase();
        StringBuffer letters = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > 96 && word.charAt(i) < 100) {
                letters.append(2);
            } else if (word.charAt(i) > 99 && word.charAt(i) < 103) {
                letters.append(3);
            } else if (word.charAt(i) > 102 && word.charAt(i) < 106) {
                letters.append(4);
            } else if (word.charAt(i) > 105 && word.charAt(i) < 109) {
                letters.append(5);
            } else if (word.charAt(i) > 108 && word.charAt(i) < 112) {
                letters.append(6);
            } else if (word.charAt(i) > 111 && word.charAt(i) < 116) {
                letters.append(7);
            } else if (word.charAt(i) > 115 && word.charAt(i) < 119) {
                letters.append(8);
            } else if (word.charAt(i) > 118 && word.charAt(i) < 123) {
                letters.append(9);
            } else {
                letters.append(" ");
            }
        }
        return letters.toString();
    }

    /**
     * Method checks if the word contains all valid characters
     * @param word
     * @return true if the word is valid
     */
    public static boolean isValidWord(String word) {
        return word.matches("[a-z]*");
    }

    /**
     * signatureToWords checks if the signature value provided as the argument of the method equals the signature
     * value of any dictionary entries. If they are not lowercase, they are converted lowercase & added to
     * a hashset that stores the set of returned words.
     * <p>
     * This method is quite inefficient as for each signature query it needs to loop through
     * the entire list. If the words were stored in an set that's more managable, it would be
     * much faster for larger amounts of queries. It would still need to read the words from the
     * file once, but once a set is created, its elements could be searched much more efficiently.
     * (see predictive.ListDictionary for more efficient implementation)
     *
     * @param signature dictionary entries are checked against
     * @return set of suggested words matching the signature
     */
    public static Set<String> signatureToWords(String signature) {
        HashSet setOfSuggestions = new HashSet<>();
        try {
            Scanner words = new Scanner(new FileReader("/usr/share/dict/words"));
            while (words.hasNext()) {
                String suggestion = words.nextLine().toLowerCase();
                if (wordToSignature(suggestion).equals(signature)) {
                    if (isValidWord(suggestion)) {
                        setOfSuggestions.add(suggestion);
                    } else {
                        setOfSuggestions.add(suggestion.toLowerCase());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return setOfSuggestions;
    }
}
