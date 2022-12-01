package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/determine-if-string-halves-are-alike/">Task description</a>
 * Difficulty: easy
 */
public class DetermineIfStringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        String vowels = "aeiou";
        char[] chars = s.toCharArray();

        int leftHalfVowelCount = 0;
        int rightHalfVowelCount = 0;
        for (int i = 0; i < chars.length; i++) {
            char letter = Character.toLowerCase(chars[i]);

            if (vowels.indexOf(letter) != -1) {
                if (i < chars.length / 2)
                    leftHalfVowelCount++;
                if (i > (chars.length - 1) / 2)
                    rightHalfVowelCount++;
            }
        }
        return leftHalfVowelCount == rightHalfVowelCount;
    }
}
