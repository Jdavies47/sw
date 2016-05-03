package predictive;

/**
 * Created by zsolt on 16/02/16.
 */
public class Sigs2WordsTree {
    public static void main(String[] args) {
        TreeDictionary td = new TreeDictionary("/usr/share/dict/words");
        for (String s : args) {
            System.out.println(td.signatureToWords(s));
        }
    }
}
