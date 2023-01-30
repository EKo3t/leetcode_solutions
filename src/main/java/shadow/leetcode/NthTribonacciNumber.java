package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number">Task description</a>
 * Difficulty: easy
 */
public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int[] numbers = new int[4];
        numbers[1] = 1;
        numbers[2] = 1;
        if (n < 3)
            return numbers[n];

        for (int i = 3; i <= n; i++) {
            numbers[3] = numbers[0] + numbers[1] + numbers[2];
            numbers[0] = numbers[1];
            numbers[1] = numbers[2];
            numbers[2] = numbers[3];
        }
        return numbers[3];
    }
}
