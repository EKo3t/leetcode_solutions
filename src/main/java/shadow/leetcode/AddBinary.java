package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/add-binary/">Task description</a>
 * difficulty: Easy
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        byte nextRankIncrement = 0;
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder result = new StringBuilder();
        int bIterator = b.length() - 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            int digitFromA = a.charAt(i) - '0';
            int digitFromB = bIterator >= 0 ? b.charAt(bIterator) - '0' : 0;
            if (bIterator >= 0)
                bIterator--;

            int sumDigit = nextRankIncrement + digitFromA + digitFromB;
            if (sumDigit > 1) {
                nextRankIncrement = 1;
                sumDigit -= 2;
            } else {
                nextRankIncrement = 0;
            }
            result.append(sumDigit);
        }
        if (nextRankIncrement == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}
