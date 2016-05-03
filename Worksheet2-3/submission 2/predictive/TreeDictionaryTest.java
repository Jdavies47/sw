package predictive;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by zsolt on 16/02/16.
 */
public class TreeDictionaryTest {

    @Test
    public void testSignatureToWords() throws Exception {
        TreeDictionary td = new TreeDictionary("/usr/share/dict/words");

        assertTrue(td.signatureToWords("4663").contains("home"));
        assertTrue(td.signatureToWords("2").contains("a"));
        assertTrue(td.signatureToWords("999").contains("zzz"));
        assertTrue(td.signatureToWords("1231324325425215135235").isEmpty());
        assertTrue(td.signatureToWords("").isEmpty());
    }
}