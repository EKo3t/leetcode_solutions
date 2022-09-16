package shadow.leetcode;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @see <a href="https://leetcode.com/problems/length-of-last-word/">Task description</a>
 * Difficulty: medium
 */
class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        CharacterIterator iterator = new StringCharacterIterator(s);

        int lastWordLength = 0;
        int currentWordLength = 0;
        char currentChar = iterator.current();
        while (currentChar != CharacterIterator.DONE) {
            if (currentChar>= 'a' && currentChar<= 'z' || currentChar>= 'A' && currentChar<= 'Z') {
                currentWordLength += 1;
            } else {
                if (currentWordLength > 0)
                    lastWordLength = currentWordLength;
                currentWordLength = 0;
            }
            currentChar = iterator.next();
        }
        if (currentWordLength > 0)
            lastWordLength = currentWordLength;

        return lastWordLength;
    }
}
