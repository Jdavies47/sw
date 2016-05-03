package predictive;

/**
 * Created by zsolt on 11/02/16.
 */
public class Sigs2WordsMap {
    public static void main(String[] args) {
        MapDictionary dictionary = new MapDictionary("/usr/share/dict/words");
        for(int i = 0; i < args.length; i++){
            System.out.println(dictionary.signatureToWords(args[i]));
        }
    }
}
