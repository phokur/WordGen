
import java.util.ArrayList;
import java.util.List;

/**
 * Code found:
 * http://codereview.stackexchange.com/questions/41510/calculate-all-possible-combinations-of-given-characters
 * @author SZupancic
 */
public class Permutation {

    // Returns the list 
    static List strings = new ArrayList();

    public List possibleStrings(int maxLength, char[] alphabet, String curr) {
        // If the current string has reached it's maximum length
        if (curr.length() == maxLength) {
            strings.add(curr);
            // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                possibleStrings(maxLength, alphabet, curr);
                curr = oldCurr;
            }
        }
        return strings;
    }
}
