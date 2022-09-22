package shadow.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @see <a href="https://leetcode.com/problems/reverse-words-in-a-string-iii/submissions/">Task description</a>
 * Difficulty: easy
 */
public class ReverseWordsInAString3 {

    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
            .map(word -> new StringBuilder(word).reverse().toString())
            .collect(Collectors.joining(" "));
    }
}
