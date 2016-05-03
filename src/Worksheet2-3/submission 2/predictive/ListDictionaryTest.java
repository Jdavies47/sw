package predictive;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zsolt on 09/02/16.
 */
public class ListDictionaryTest {

    @Test
    /**
     * WordToSignature tests:
     *  1. regular String input with 1 uppercase character
     *  2. 6 invalid characters in a String
     *  3. valid characters mixed with invalid characters
     *  4. empty string
     */
    public void testWordToSignature() throws Exception {
        ListDictionary dictionary = new ListDictionary("/usr/share/dict/words");

        String expected1 = "4663";
        String expected2 = "      ";
        String expected3 = "4 3 5 5 6";
        String expected4 = "";

        String actual1 = dictionary.wordToSignature("hOme");
        String actual2 = dictionary.wordToSignature("Őß=!.Ó");
        String actual3 = dictionary.wordToSignature("h-e!l$l|o");
        String actual4 = dictionary.wordToSignature("");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @Test
    /**
     *  signatureToWords tests
     *  1. if the String "home" is among the returned words for the signature value of 4663
     *  2. if the String "hello" is among the returned words for the signature value of 43556
     *  3. checking the first valid entry in the dictionary
     *  4. checking the last valid entry in the dictionary
     */
    public void testSignatureToWords() throws Exception {
        ListDictionary dictionary = new ListDictionary("/usr/share/dict/words");

        // TESTING A REGULAR ENTRY
        assertTrue(dictionary.signatureToWords("4663").contains("home"));

        // TESTING IF THE FIRST ENTRY IN THE DICTIONARY IS READ IN AND RETURNED
        assertTrue(dictionary.signatureToWords("2").contains("a"));

        // TESTING IF THE LAST ENTRY IN THE DICTIONARY IS READ IN AND RETURNED
        assertTrue(dictionary.signatureToWords("999").contains("zzz"));

        // TESTING IF THE SIGNATURE IS EMPTY
        assertTrue(dictionary.signatureToWords("").isEmpty());

        // TESTING IF THE SIGNATURE DOESN'T EXIST IN THE DICTIONARY
        assertTrue(dictionary.signatureToWords("1").isEmpty());
    }
}