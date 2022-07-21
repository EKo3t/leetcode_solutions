package shadow.leetcode.length_of_the_last_word;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

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
