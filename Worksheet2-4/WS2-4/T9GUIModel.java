import java.util.ArrayList;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Zsolt Pazmandy on 18/02/16.
 * MODEL CLASS for the GUI implementation of the T9 TreeDictionary application
 */
public class T9GUIModel extends Observable {

    private TreeDictionary dictionary;
    private int index = 0;
    private Set<String> resultList = new TreeSet<>();
    private String signature = "";
    private int wordCount;
    private ArrayList<String> wordsEntered = new ArrayList<>();
    private String displayed = "";

    T9GUIModel() {
        dictionary = new TreeDictionary
                ("/usr/share/dict/words");
    }

    /**
     * Getter for the currently edited word.
     * @return the word being edited
     */
    public String getDisplayed() {
        return displayed;
    }

    /**
     * Setter for the currently edited word.
     * @param displayed the word being edited
     */
    public void setDisplayed(String displayed) {
        this.displayed = displayed;
        notifyObservers();
    }

    /**
     * Getter for all the words that have been entered and completed.
     * @return the words that have been entered and completed
     */
    public ArrayList<String> getWordsEntered() {
        return wordsEntered;
    }

    /**
     * Setter for all the words that have been entered and completed.
     * @param wordsEntered the words that have been entered and completed
     */
    public void setWordsEntered(ArrayList<String> wordsEntered) {
        this.wordsEntered = wordsEntered;
        notifyObservers();
    }

    /**
     * Setter for the amount of words that have been entered and completed.
     * @param wordCount int of amount of numbers that have been entered already.
     */
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
        notifyObservers();
    }

    /**
     * Getter for the amount of words that have been entered and completed.
     * @return int of amount of numbers that have been entered already.
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Setter for the index in the array of matches for the current signature.
     * @param i index of the result that's being edited.
     */
    public void setIndex(int i) {
        this.index = i;
    }

    /**
     * Getter for the index in the array of mathces for the current signature.
     * @return the index of the word in the array that's being edited
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Setter for the signature of the currently edited word.
     * @param signature of the current word
     */
    public void setSignature(String signature) {
        this.signature = signature;
        notifyObservers();
    }

    /**
     * Getter for the currently edited word.
     * @return the currently edited word's signature.
     */
    public String getSignature() {
        return this.signature;
    }

    /**
     * Method to update the resultList set, containing all the matches for
     * the current signature from the dictionary.
     * @param signature the signature whose words we're looking to find.
     */
    public void currentHits(String signature) {
        this.resultList = dictionary.signatureToWords(signature);
        notifyObservers();
    }

    /**
     * Getter for the current resultList.
     * @return resultList for the current signature.
     */
    public Set<String> getResultList() {
        return this.resultList;
    }

    /**
     * Returns the word for the current signature at index j.
     * @param j index of the word to be returned in the set
     * @return word as String.
     */
    public String getThis(int j) {
        ArrayList<String> elements = new ArrayList<>();
        elements.addAll(resultList);
        if (elements.isEmpty()) {
            return dictionary.signatureToWords(signature)
                    .toString().replace(",", "").replace("[", "").replace("]", "")
                    .trim();
        } else
            return elements.get(j);

    }
}
