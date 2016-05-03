package predictive;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by zsolt on 16/02/16.
 */
public class MapDictionaryTest {

    @Test
    public void testSignatureToWords() throws Exception {
        MapDictionary md = new MapDictionary("/usr/share/dict/words");

        // TESTING A REGULAR ENTRY
        assertTrue(md.signatureToWords("4663").contains("home"));

        // TESTING IF THE FIRST ENTRY IN THE DICTIONARY IS READ IN AND RETURNED
        assertTrue(md.signatureToWords("2").contains("a"));

        // TESTING IF THE LAST ENTRY IN THE DICTIONARY IS READ IN AND RETURNED
        assertTrue(md.signatureToWords("999").contains("zzz"));

        // TESTING IF THE SIGNATURE IS EMPTY
        assertTrue(md.signatureToWords("").isEmpty());

        // TESTING IF THE SIGNATURE DOESN'T EXIST IN THE DICTIONARY
        assertTrue(md.signatureToWords("23264373467347").isEmpty());
    }
}