package predictive;

/**
 * Created by zsolt on 08/02/16.
 * Command-line application that takes in arguments & sends them to the wordToSignature method
 */
public class Word2SigProto {
    public static void main(String[] args) {
        PredictivePrototype dictionary = new PredictivePrototype();
        for (int i = 0; i < args.length; i++) {
            System.out.println(dictionary.wordToSignature(args[i]));
        }
    }
}
