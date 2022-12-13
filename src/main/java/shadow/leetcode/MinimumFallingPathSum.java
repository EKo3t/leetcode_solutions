package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/minimum-falling-path-sum">Task description</a>
 * Difficulty: medium
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int[][] minSum = new int[rowCount][colCount];
        for (int[] row : minSum)
            Arrays.fill(row, Integer.MAX_VALUE);
        System.arraycopy(matrix[0], 0, minSum[0], 0, colCount);

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int upperLeft = j - 1 >= 0 ? minSum[i - 1][j - 1] : Integer.MAX_VALUE;
                int upperMiddle = minSum[i - 1][j];
                int upperRight = j + 1 < matrix[i - 1].length ? minSum[i - 1][j + 1] : Integer.MAX_VALUE;
                int currentMin = Integer.min(Integer.min(upperLeft, upperMiddle), upperRight) + matrix[i][j];
                minSum[i][j] = Integer.min(minSum[i][j], currentMin);
            }
        }
        return Arrays.stream(minSum[rowCount - 1]).min().getAsInt();
    }
}
