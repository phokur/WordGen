
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SZupancic
 */
public class Main {

    public Main() {
        System.out.println("Syntax: WordGen %letters% %length%");
        System.out.println("ie: WordGen abcdef 4");
    }

    public Main(String letters, int length) {
        run(letters, length);
    }

    public static void main(String[] args) {
        if (args.length == 2) {
            new Main(args[0], Integer.parseInt(args[1]));
        } else {
            new Main();
        }
    }

    public void run(String input, int wordSize) {
        Permutation perm = new Permutation();
        Dictionary dict = new Dictionary();

        // Create an alphabet to work with
        char[] alphabet = input.toCharArray();

        // Find all possible permutations of this alphabet
        List strings = perm.possibleStrings(wordSize, alphabet, "");

        // List of permutations that are english words
        List words = new ArrayList();
        // Find words in list of permutations
        for (int i = 0; i < strings.size(); i++) {
            // Set current word in list
            String currentWord = (String) strings.get(i);
            // If it is an actual word, add to final list
            if (dict.contains(currentWord) && !words.contains(currentWord)) {
                words.add(currentWord);
            }
        }

        // List of unique words made up of input chars
        List uniqueWords = new ArrayList();
        // Build final list from list of words
        for (int j = 0; j < words.size(); j++) {
            String word = (String) words.get(j);
            // Check each letter against each word
            for (int k = 0; k < alphabet.length; k++) {
                // Compare count of each letter to the count of the input
                String bet = "" + alphabet[k];
                int lenOfTest = input.length() - input.replace("" + bet, "").length();
                int lenOfWord = word.length() - word.replace("" + bet, "").length();
                // Only add if used letters match
                if (lenOfTest >= lenOfWord) {
                    // If on final char comparison AND not already in list, add
                    if ((k == alphabet.length - 1) && !uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                } else {
                    break;
                }
            }
        }

        // Print final list
        System.out.println("\nFinal List:");
        for (int l = 0; l < uniqueWords.size(); l++) {
            System.out.println(uniqueWords.get(l));
        }
    }
}
