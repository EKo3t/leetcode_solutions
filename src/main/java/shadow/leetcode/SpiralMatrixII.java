package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/spiral-matrix-ii">Task description</a>
 * Difficulty: medium
 */
public class SpiralMatrixII {

    private static final int[] MOVES_X = new int[] {1, 0, -1, 0};
    private static final int[] MOVES_Y = new int[] {0, 1, 0, -1};

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        int moveIndex = 0;
        int curY = 0;
        int curX = 0;
        while (counter <= n * n) {
            matrix[curY][curX] = counter;
            if (needToChangeDirection(matrix, curY, curX, MOVES_Y[moveIndex], MOVES_X[moveIndex])) {
                moveIndex = (moveIndex + 1) % 4;
            }
            curY += MOVES_Y[moveIndex];
            curX += MOVES_X[moveIndex];
            counter++;
        }
        return matrix;
    }

    private boolean needToChangeDirection(int[][] matrix, int curY, int curX, int deltaY, int deltaX) {
        int newY = curY + deltaY;
        int newX = curX + deltaX;

        int size = matrix.length;
        if (newY >= size || newY < 0 || newX >= size || newX < 0) return true;
        return matrix[newY][newX] != 0;
    }
}
