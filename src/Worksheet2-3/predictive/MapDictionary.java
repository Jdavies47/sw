package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.Dictionary;

/**
 * WS 2-3 PART 3
 * Created by zsolt on 10/02/16.
 * The current class stores the dictionary using a generic
 * multi-valued map. Using a map data can be retrieved
 * quickly by signature. The values stored in the map
 * are words grouped together by their respective signatures
 * which is their key.
 */
public class MapDictionary implements Dictionary {

    // TreeMap*: K = signature, V = matching words stored in a treeset
    TreeMap<String, HashSet<String>> wordsMap = new TreeMap<>();

    public MapDictionary(String filepath) {
        try {
            Scanner reader = new Scanner(new FileReader(filepath));
            while (reader.hasNext()) {
                String word = reader.nextLine().toLowerCase();
                String sign = wordToSignature(word);
                if (wordsMap.containsKey(sign)) {
                    HashSet<String> groupOfMatches = wordsMap.get(sign);
                    if (!groupOfMatches.contains(word)) // IF THE CURRENT SET OF VALUES DOES NOT CONTAIN THE WORD YET
                        if (isValidWord(word)) // IF IT IS A VALID WORD
                            groupOfMatches.add(word); // ADD THE WORD TO THE RETURN SET
                    wordsMap.put(sign, groupOfMatches); // ADD THE VALUE TO THE RIGHT KEY
                } else {
                    HashSet<String> groupOfMatches = new HashSet<>();
                    if (isValidWord(word))
                        groupOfMatches.add(word);
                    wordsMap.put(sign, groupOfMatches);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method checks if the word contains all valid characters
     *
     * @param word
     * @return true if the word is valid
     */
    public boolean isValidWord(String word) {
        return word.matches("[a-z]*");
    }

    /**
     * Method returns the signature value of the input string. Character-by-character it evaluates
     * the ASCII values & adds the corresponding T9 key to the StringBuffer. When all the characters
     * in the input word have been examined, it returns whatever is in the StringBuffer.
     * Lowercase & Uppercase characters are both accounted for, non-alphabetic characters send an
     * empty " " in the StringBuffer.
     *
     * @param word the word whose signature value we're looking for
     * @return signature value of the input word
     */
    public String wordToSignature(String word) {
        StringBuffer numbers = new StringBuffer();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > 96 && word.charAt(i) < 100) {
                numbers.append(2);
            } else if (word.charAt(i) > 99 && word.charAt(i) < 103) {
                numbers.append(3);
            } else if (word.charAt(i) > 102 && word.charAt(i) < 106) {
                numbers.append(4);
            } else if (word.charAt(i) > 105 && word.charAt(i) < 109) {
                numbers.append(5);
            } else if (word.charAt(i) > 108 && word.charAt(i) < 112) {
                numbers.append(6);
            } else if (word.charAt(i) > 111 && word.charAt(i) < 116) {
                numbers.append(7);
            } else if (word.charAt(i) > 115 && word.charAt(i) < 119) {
                numbers.append(8);
            } else if (word.charAt(i) > 118 && word.charAt(i) < 123) {
                numbers.append(9);
            } else {
                numbers.append(" ");
            }
        }
        return numbers.toString();
    }

    /**
     * Method returns a set of matches for the input signature.
     *
     * @param signature
     * @return values from the map using the signature.
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        if (signature.length() == 0) {
            return new TreeSet<>();
        } else if (!wordsMap.containsKey(signature)) {
            return new TreeSet<>();
        } else {
            return wordsMap.get(signature);
        }
    }
}
