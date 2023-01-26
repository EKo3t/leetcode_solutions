package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/rotate-image/">Task description</a>
 * Difficulty: medium
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if (matrix.length == 1) return;

        var initialLoopCell = _2DCell.from(0, 0);

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;


        while (initialLoopCell.row < rowCount / 2) {
            var currentCell = copy(initialLoopCell);

            for (int i = currentCell.column; i < columnCount - currentCell.row - 1; i++) {
                int temp = matrix[currentCell.row][currentCell.column];
                for (int turnAngle = 0; turnAngle < 360; turnAngle+=90) {
                    var rotated = rotate90Clockwise(currentCell, rowCount, columnCount, turnAngle);
                    temp = replaceValue(matrix, temp, rotated);
                    currentCell = rotated;
                }
                currentCell = _2DCell.from(currentCell.row, currentCell.column + 1);
            }

            initialLoopCell = _2DCell.from(initialLoopCell.row + 1, initialLoopCell.column + 1);
        }
    }

    // returns value which should be moved further
    private int replaceValue(int[][] matrix, int replaceWith, _2DCell toReplace) {
        int temp = matrix[toReplace.row][toReplace.column];
        matrix[toReplace.row][toReplace.column] = replaceWith;
        return temp;
    }

    private _2DCell rotate90Clockwise(_2DCell cell, int rowCount, int columnCount, int currentRotation) {
        if (currentRotation == 0 || currentRotation == 90) {
            return new _2DCell(cell.column, columnCount - cell.row - 1);
        }

        if (currentRotation == 180 || currentRotation == 270) {
            return new _2DCell(cell.column, rowCount - cell.row - 1);
        }
        throw new RuntimeException("Rotation should be divided by 90 without modulo");
    }

    private _2DCell copy(_2DCell cell) {
        return _2DCell.from(cell.row, cell.column);
    }

    private record _2DCell(int row, int column) {

        static _2DCell from(int row, int column) {
            return new _2DCell(row, column);
        }
    }
}
