package shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> results = new ArrayList<>();

        int[] maxLetterOccurrences = new int[26];
        for (String word : words2) {
            int[] currentOccurrences = calculateLetterOccurrences(word);
            for (int i = 0; i < 26; i++) {
                if (currentOccurrences[i] > maxLetterOccurrences[i]) {
                    maxLetterOccurrences[i] = currentOccurrences[i];
                }
            }
        }

        for (String word : words1) {
            int[] currentOccurrences = calculateLetterOccurrences(word);
            boolean hasMoreOccurrencesThanMax = true;
            for (int i = 0; i < 26; i++) {
                if (currentOccurrences[i] < maxLetterOccurrences[i]) {
                    hasMoreOccurrencesThanMax = false;
                    break;
                }
            }
            if (hasMoreOccurrencesThanMax) {
                results.add(word);
            }
        }
        return results;
    }

    private int[] calculateLetterOccurrences(String word) {
        int[] currentOccurrences = new int[26];
        char[] wordChars = word.toCharArray();
        for (char wordChar : wordChars) {
            currentOccurrences[wordChar - 'a'] += 1;
        }
        return currentOccurrences;
    }
}
