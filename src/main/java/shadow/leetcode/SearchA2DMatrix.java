package shadow.leetcode;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int columnCount = matrix[0].length;

        int l = 0;
        int r = matrix.length * matrix[0].length - 1;

        while (l <= r) {
            int middle = (l + r) / 2;
            int row = middle / columnCount;
            int column = middle - columnCount * row;

            if (matrix[row][column] < target)
                l = middle + 1;

            if (matrix[row][column] > target)
                r = middle - 1;

            if (matrix[row][column] == target)
                return true;
        }
        return false;
    }
}
