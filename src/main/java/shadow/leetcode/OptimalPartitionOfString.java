package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/optimal-partition-of-string">Task description</a>
 * Difficulty: medium
 */
public class OptimalPartitionOfString {

    public int partitionString(String s) {
        int usedChars = 0;
        char[] chars = s.toCharArray();
        int answer = 1;
        for (char aChar : chars) {
            int charBit = 1 << (aChar - 'a');
            if ((usedChars & charBit) == charBit) {
                answer++;
                usedChars = charBit;
            } else usedChars |= charBit;
        }
        return answer;
    }
}
