package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/sqrtx">Task description</a>
 * Difficulty: easy
 */
public class SqrtX {

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l < r) {
            int middle = (l + r + 1) / 2;
            if (x / middle < middle) {
                r = middle - 1;
            } else if (middle * middle < x) {
                l = middle;
            } else if (middle * middle == x) {
                return middle;
            }
        }
        return l;
    }
}
