package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/integer-to-roman">Task description</a>
 * Difficulty: medium
 */
public class IntegerToRoman {

    private static final String[] THOUSANDS = new String[] {"M", "MM", "MMM"};
    private static final String[] HUNDREDS = new String[] {"C", "СС", "ССС", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private static final String[] TENNERS = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] DIGITS = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        byte thousands = (byte) (num / 1000);
        num -= thousands * 1000;
        byte hundreds = (byte) (num / 100);
        num -= hundreds * 100;
        byte tenners = (byte) (num / 10);
        num -= tenners * 10;
        // remaining in the num is num % 10

        StringBuilder sb = new StringBuilder();
        if (thousands > 0) sb.append(THOUSANDS[thousands - 1]);
        if (hundreds > 0) sb.append(HUNDREDS[hundreds - 1]);
        if (tenners > 0) sb.append(TENNERS[tenners - 1]);
        if (num > 0) sb.append(DIGITS[num - 1]);
        return sb.toString();
    }
}
