package predictive;

/**
 * Created by zsolt on 09/02/16.
 * Command-line application that takes in arguments & sends them to the signatureToWords method
 * from the predictive.PredictivePrototype class
 */
public class Sigs2WordsProto {
    public static void main(String[] args) {
        PredictivePrototype dictionary = new PredictivePrototype();
        for (int i = 0; i < args.length; i++) {
            System.out.println(dictionary.signatureToWords(args[i]));
        }
    }
}
