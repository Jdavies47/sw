package predictive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * PART 2
 * The current class uses a scanner to read all the words in from the external file and stores them
 * in an ArrayList of WordSig.
 * Created by zsolt on 04/02/16.
 */
public class ListDictionary implements Dictionary {

    ArrayList<WordSig> wordsList = new ArrayList<>();
    TreeSet<String> setOfSuggestions = new TreeSet<>();

    /**
     * Constructor: reads all words in from an external file using a scanner & stores it in an
     * ArrayList of WordSig (pairs of word+their signature values).
     * Uppercase words are converted to lowercase words.
     * The ArrayList is then sorted using the WordSig class's compareTo method.
     */
    public ListDictionary() {
        try {
            Scanner words = new Scanner(new FileReader("/usr/share/dict/words"));
            while (words.hasNextLine()) {
                String temp = words.nextLine().toLowerCase();
                wordsList.add(new WordSig(temp, wordToSignature(temp)));
            }
            wordsList.sort(WordSig::compareTo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > 96 && word.charAt(i) < 100 || word.charAt(i) > 64 && word.charAt(i) < 68) {
                numbers.append(2);
            } else if (word.charAt(i) > 99 && word.charAt(i) < 103 || word.charAt(i) > 67 && word.charAt(i) < 71) {
                numbers.append(3);
            } else if (word.charAt(i) > 102 && word.charAt(i) < 106 || word.charAt(i) > 70 && word.charAt(i) < 74) {
                numbers.append(4);
            } else if (word.charAt(i) > 105 && word.charAt(i) < 109 || word.charAt(i) > 73 && word.charAt(i) < 77) {
                numbers.append(5);
            } else if (word.charAt(i) > 108 && word.charAt(i) < 112 || word.charAt(i) > 76 && word.charAt(i) < 80) {
                numbers.append(6);
            } else if (word.charAt(i) > 111 && word.charAt(i) < 116 || word.charAt(i) > 79 && word.charAt(i) < 84) {
                numbers.append(7);
            } else if (word.charAt(i) > 115 && word.charAt(i) < 119 || word.charAt(i) > 83 && word.charAt(i) < 87) {
                numbers.append(8);
            } else if (word.charAt(i) > 118 && word.charAt(i) < 123 || word.charAt(i) > 86 && word.charAt(i) < 91) {
                numbers.append(9);
            } else {
                numbers.append(" ");
            }
        }
        return numbers.toString();
    }

    /**
     * Uses binarysearch to find an element in the wordsList whose signature equals the one provided
     * as the argument. After determining the index of an element that is guaranteed to be a match for the
     * signature, both directions' elements are also checked adding each consequent match to
     * the setOfSuggestions TreeSet of String.
     *
     * @param signature signature value the method returns the corresponding words for
     * @return TreeSet of matching words to the signature provided as an argument
     */
    public TreeSet<String> signatureToWords(String signature) {

        int more = Collections.binarySearch(wordsList, new WordSig("", signature),
                WordSig::compareTo);
        int less = more;

        // checking if there are other hits to the right & adding them to the arrayOfSuggestions
        while (wordsList.get(more).compareTo(new WordSig("", signature)) == 0) {
            setOfSuggestions.add(wordsList.get(more).getWords());
            more++;
        }

        // checking if there are other hits to the left & adding them to the arrayOfSuggestions
        while (wordsList.get(less).compareTo(new WordSig("", signature)) == 0) {
            setOfSuggestions.add(wordsList.get(less).getWords());
            less--;
        }
        return setOfSuggestions;
    }
}
