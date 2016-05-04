package predictive;

/**
 * Created by zsolt on 04/02/16.
 */
public class WordSig implements Comparable<WordSig> {
    private String words;
    private String signature;

    public WordSig(String words, String signature) {
        this.words = words;
        this.signature = signature;
    }

    public String getWords() {
        return words;
    }

    public String getSignature() {
        return signature;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public int compareTo(WordSig that) {
        return this.signature.compareTo(that.signature);
    }
}