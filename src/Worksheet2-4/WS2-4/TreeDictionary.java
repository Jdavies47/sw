
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * WS 2-3 PART 4
 * TreeDictionary creates a datastructure reading the words
 * from the dictionary (whose filepath is provided as the
 * argument of the constructor). There are 2 constructors:
 * the first one initiates the reading process from the file
 * using a scanner while the second constructor is the one
 * that is called every other time. All TreeDictionary
 * objects have variables: an array of treedictionary()
 * objects (8, representing each signature character), and
 * a TreeSet of words that are stored on that level.
 * The first constructor's level does not contain any word
 * as without the insertion of any signature, no word is
 * supposed to be returned.
 */
public class TreeDictionary implements Dictionary {

    // VARS
    // AN ARRAY OF TREEDICTIONARY OBJECTS
    private TreeDictionary[] subTrees;

    // A SET OF WORDS
    private Set<String> wordsSet;

    // CONSTRUCTOR#1 FOR ROOT NODE
    public TreeDictionary(String filepath) {

        // INITIALISING VARS
        wordsSet = new TreeSet<>();
        subTrees = new TreeDictionary[8];

        // READING FILE
        try { // IF THE FILE EXISTS

            // DECLARE A SCANNER
            Scanner file = new Scanner(new FileReader(filepath));

            // WHILE THERE ARE WORDS IN THE DATABASE
            while (file.hasNextLine()) {

                // STORE THEM FOR EACH LOOP
                String word = file.nextLine().toLowerCase();

                // IF THEY'RE VALID WORDS
                if (isValidWord(word)) {

                    // CREATE THEIR SIGNATURE VALUES
                    String sign = wordToSignature(word);

                    // SEND DATA TO THE METHOD THAT ADDS WORD TO THE TREE
                    addWordToTree(word, sign, 0);
                }
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // CONSTRUCTOR#2 FOR EVERY OTHER NODE
    public TreeDictionary() {

        // INITIALISING VARS
        wordsSet = new TreeSet<>();
        subTrees = new TreeDictionary[8];
    }

    /**
     * addWordToTree is called by the TreeDictionary(String filepath) constructor.
     * It stores its argument word in the tree dictionary structure by reading
     * each character of its signature value to determine which subtree the word
     * is supposed to be stored in. It's called recursively as many times as many
     * characters there are in the signature.
     *
     * @param word      that's to be stored
     * @param signature the word's signature value
     * @param i         index used to count the times the method is called recursively
     */
    public void addWordToTree(String word, String signature, int i) {

        // BASE CASE: WHEN THE LENGTH OF THE WORD EQUALS THE AMOUNT
        // OF TIMES THE METHOD'S BEEN CALLED RECURSIVELY = WE ARE
        // AT THE LOWEST LEVEL WHERE THE WORD IS STORED
        if (signature.length() == i) {
            wordsSet.add(word);

        } else {

            // BUTTON = THE KEY THAT'S PRESSED (CHARACTER OF THE SIGNATURE) (2-8)
            int button = Character.getNumericValue(signature.charAt(i));

            // INDEX = THE INDEX OF THE ARRAYS (0-7) IT'S ALWAYS THE
            // SIGNATURE VALUE -2, BECAUSE 2 IS THE LOWEST BUTTON VALUE
            // WHEREAS 0 IS THE LOWEST INDEX
            int index = button - 2;

            // IF THE TREE DOESN'T EXIST YET
            if (subTrees[index] == null) {

                // CREATE IT
                subTrees[index] = new TreeDictionary();
            }

            // RECURSIVE CALL WITH THE SAME ARGUMENTS, i INCREMENTED
            subTrees[index].addWordToTree(word, signature, i + 1);
        }
    }

    /**
     * Method returns the signature value of the input string.
     * Character-by-character it evaluates
     * the ASCII values & adds the corresponding T9 key to the
     * StringBuffer. When all the characters
     * in the input word have been examined, it returns whatever
     * is in the StringBuffer.
     * Lowercase & Uppercase characters are both accounted for,
     * non-alphabetic characters send an
     * empty " " in the StringBuffer.
     *
     * @param word the word whose signature value we're looking for
     * @return signature value of the input word
     */
    public String wordToSignature(String word) {
        StringBuffer numbers = new StringBuffer();
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) > 96 && word.charAt(i) < 100) {
                numbers.append(2);
            } else if (word.charAt(i) > 99 && word.charAt(i) < 103) {
                numbers.append(3);
            } else if (word.charAt(i) > 102 && word.charAt(i) < 106) {
                numbers.append(4);
            } else if (word.charAt(i) > 105 && word.charAt(i) < 109) {
                numbers.append(5);
            } else if (word.charAt(i) > 108 && word.charAt(i) < 112) {
                numbers.append(6);
            } else if (word.charAt(i) > 111 && word.charAt(i) < 116) {
                numbers.append(7);
            } else if (word.charAt(i) > 115 && word.charAt(i) < 119) {
                numbers.append(8);
            } else if (word.charAt(i) > 118 && word.charAt(i) < 123) {
                numbers.append(9);
            } else {
                numbers.append(" ");
            }
        }
        return numbers.toString();
    }

    /**
     * Method checks if the word contains all valid characters
     *
     * @param word
     * @return true if the word is valid
     */
    public static boolean isValidWord(String word) {
        return (word.matches("[a-z]*"));
    }

    /**
     * signatureToWords returns a set of words that are of the
     * same length as the signature, that are exact matches for
     * the input signature AND any word that begins with that
     * signature but is not yet a complete word
     *
     * @param signature
     * @return
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        // RETURN AN EMPTY TREE IF THE STRING IS EMPTY
        if (signature.length() == 0) {
            return new TreeSet<>();
        }

        // SET COUNTER TO GET INDIVIDUAL VALUES USING SUBSTRING
        int counter = 1;

        // CREATE AN ARRAY OF keysPressed THAT'S THE SAME
        // LENGTH AS THE SIGNATURE'S LENGTH
        String[] keysPressed = new String[signature.length()];

        // LOOP THROUGH THE ELEMENTS OF THE SIGNATURE
        for (int nextSig = 0; nextSig < signature.length(); nextSig++) {

            // ASSIGN THE SIGNATURE'S VALUES TO THE keysPressed ARRAY
            keysPressed[nextSig] = signature.substring(nextSig, counter);

            // INCREMENT EXTERNAL COUNTER
            counter++;
        }

        TreeDictionary tree = this;

        // RESETTING THE COUNTER
        counter = 0;

        // ASSIGNING THE VALUE OF THE FIRST KEY PRESSED TO BUTTON
        // WHICH WILL BE USED TO DETERMINE THE ARRAY'S INDEX
        String button = keysPressed[counter];
        if(Integer.parseInt(button)==1 ){
            return new TreeSet<>();
        }

        while (signature.length() > counter) {

            // RETURN AN EMPTY SET IN CASE THE TREE'S SUBTREE AT
            // THE GIVEN LOCATION IS EMPTY
            if (tree.getSubTrees()[Integer.parseInt(button) - 2] == null)
                return new TreeSet<>();

            // IF IT ISN'T EMPTY, ASSIGN IT TO this TREE
            tree = tree.getSubTrees()[Integer.parseInt(button) - 2];

            counter++;

            if (signature.length() > counter)

                // ASSIGN THE NEXT KEY PRESSED TO BUTTON BEFORE RESTARTING THE LOOP
                button = keysPressed[counter];
        }

        // RETURN THE SET HAVING IT TRIMMED TO THE SIGNATURE'S LENGTH
        // USING THE TRIM METHOD
        return trim(addSubTreesWords(tree), signature.length());
    }

    /**
     * getSubTreesWords returns the words stored in the subtrees
     * AND its parent.
     * It's called recursively as many times as there are levels
     * to go down the tree.
     * @param parent the root whose subtrees' words are to be returned
     * @return set of words stored in the parent AND its subtrees
     */
    public Set<String> addSubTreesWords(TreeDictionary parent) {

        // CREATE A NEW TREESET
        TreeSet<String> tree = new TreeSet<>();

        // IF PARENT CONTAINS ANY WORDS
        if (!parent.getWordsSet().isEmpty()) {

            // ADD ALL ITS CONTENTS TO THE SET TO BE RETURNED
            tree.addAll(parent.wordsSet);
        }

        // LOOP THROUGH THE ALL THE SUBTREES ONE LEVEL LOWER
        for (int i = 0; i < 8; i++) {

            // IF A SUBTREE EXISTS
            if (parent.getSubTrees()[i] != null) {

                // RECURSIVE CALL USING THE TREE'S
                tree.addAll(addSubTreesWords(parent.getSubTrees()[i]));
            }

        }

        // RETURN TREE
        return tree;
    }

    /**
     * trim returns the all elements of the input set trimmed to the
     * right size, which is fed in the method as its argument
     * @param untrimmed the set to be trimmed
     * @param length the length to which words are to be trimmed
     * @return the trimmed set
     */
    public Set<String> trim(Set<String> untrimmed, int length) {

        // CREATE A NEW TREESET
        TreeSet<String> output = new TreeSet<>();

        // CREATE AN ITERATOR
        Iterator<String> cursor = untrimmed.iterator();

        // LOOP THROUGH ALL THE ELEMENTS OF THE INPUT SET
        for (int i = 0; i < untrimmed.size(); i++) {

            // ADD THE TRIMMED WORD TO THE OUTPUT
            output.add(cursor.next().substring(0, length));
        }

        return output;
    }

    /**
     * getWordsSet getter
     * @return the words stored in the current level
     */
    public Set<String> getWordsSet() {
        return wordsSet;
    }

    /**
     * getSubTrees getter
     * @return the subtrees of the current level
     */
    public TreeDictionary[] getSubTrees() {
        return this.subTrees;
    }
}