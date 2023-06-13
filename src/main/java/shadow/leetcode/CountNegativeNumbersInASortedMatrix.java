package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix">Task description</a>
 * Difficulty: easy
 */
public class CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int i = grid.length - 1; i >= 0; i--)
            for (int j = grid[0].length - 1; j >= 0; j--)
                if (grid[i][j] < 0) result++;
        return result;
    }

}
