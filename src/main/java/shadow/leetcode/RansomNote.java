package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/ransom-note">Task description</a>
 * Difficulty: easy
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        ransomNote.chars().forEach(value -> letters[value - 'a']++);
        for (char c : magazine.toCharArray()) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
