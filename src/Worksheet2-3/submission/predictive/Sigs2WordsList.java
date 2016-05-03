package predictive;

/**
 * Created by zsolt on 09/02/16.
 * Command-line application that takes in arguments & sends them to the signatureToWords method

 */
public class Sigs2WordsList {
    public static void main(String[] args) {
        ListDictionary dictionary = new ListDictionary();
        for (int i = 0; i < args.length; i++) {
            System.out.println(dictionary.signatureToWords(args[i]));
        }
    }
}
