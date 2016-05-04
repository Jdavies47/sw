package predictive;

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by zsolt on 04/02/16.
 */
public class PredictiveTest {

    @org.junit.Test
    public void testWordToSignature() throws Exception {
        ListDictionary dictionary = new ListDictionary("/usr/share/dict/words");

        String expected1 = "4663";
        String expected2 = "      ";
        String expected3 = "4 3 5 5 6";
        String expected4 = "";

        String actual1 = dictionary.wordToSignature("home");
        String actual2 = dictionary.wordToSignature("Őß=!.Ó");
        String actual3 = dictionary.wordToSignature("h-e!l$l|o");
        String actual4 = dictionary.wordToSignature("");

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }

    @org.junit.Test
    public void testSignatureToWords() throws Exception {
        ListDictionary dictionary = new ListDictionary("/usr/share/dict/words");

        String expected1 = ("[immunoelectrophoretically]");
        String expected2 = ("[whatever]");
        String expected3 = ("[]");

        Set<String> actual1 = dictionary.signatureToWords("4668663532876746738422559");
        Set<String> actual2 = dictionary.signatureToWords("94283837");
        Set<String> actual3 = dictionary.signatureToWords("asdsadasd");

        assertEquals(expected1, actual1.toString());
        assertEquals(expected2, actual2.toString());
        assertEquals(expected3, actual3.toString());
    }
}