package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/">Task description</a>
 * Difficulty: easy
 */
public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
