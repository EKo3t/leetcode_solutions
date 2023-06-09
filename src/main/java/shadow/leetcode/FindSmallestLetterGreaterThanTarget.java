package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target">Task description</a>
 * Difficulty: medium
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int midIndex = (l + r) / 2;
            char mid = letters[midIndex];
            if (mid <= target)
                l = midIndex + 1;
            else r = midIndex;
        }
        if (l == letters.length || letters[l] <= target)
            return letters[0];
        else return letters[l];
    }
}
