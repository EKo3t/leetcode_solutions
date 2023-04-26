package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/add-digits">Task description</a>
 * difficulty: Easy
 */
public class AddDigits {

    public int addDigits(int num) {
        int result = num;
        while (result > 9) {
            int current = result;
            int sum = 0;
            while (current > 0) {
                sum += current % 10;
                current /= 10;
            }
            result = sum;
        }
        return result;
    }
}
