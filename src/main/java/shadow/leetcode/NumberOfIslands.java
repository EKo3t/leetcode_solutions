package shadow.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/number-of-islands/">Task description</a>
 * Difficulty: medium
 */
public class NumberOfIslands {
    // up, right, down, left
    private static final int[][] MOVEMENT_DELTAS = new int[][]{
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    private static final char EARTH_CELL = '1';

    public int numIslands(char[][] grid) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int islandsCount = 0;
        boolean[][] visitedCells = new boolean[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < columnCount; j++) {
                if (isNotVisitedEarthCell(i, j, grid, visitedCells)) {
                    visitedCells[i][j] = true;
                    islandsCount++;

                    Deque<GridCell> discoveredEarthCells = new ArrayDeque<>();
                    discoveredEarthCells.add(new GridCell(i, j));

                    occupyIsland(discoveredEarthCells, visitedCells, grid);
                }
            }
        return islandsCount;
    }

    private void occupyIsland(Deque<GridCell> discoveredEarthCells, boolean[][] visitedCells, char[][] grid) {
        while (discoveredEarthCells.size() > 0) {
            GridCell cellToMoveFurther = discoveredEarthCells.poll();
            int row = cellToMoveFurther.getRow();
            int column = cellToMoveFurther.getColumn();
            discoveredEarthCells.addAll(
                visitNewAdjacentEarthCells(row, column, grid, visitedCells)
            );
        }
    }

    private List<GridCell> visitNewAdjacentEarthCells(
        int row,
        int column,
        char[][] grid,
        boolean[][] visitedCells
    ) {
        List<GridCell> adjacentNewEarthCells = new ArrayList<>();
        int rowCount = grid.length;
        int columnCount = grid[0].length;
        for (int[] movementDelta : MOVEMENT_DELTAS) {
            int newRow = row + movementDelta[0];
            int newColumn = column + movementDelta[1];
            if (isOutsideTheMap(newRow, newColumn, rowCount, columnCount))
                continue;

            if (isNotVisitedEarthCell(newRow, newColumn, grid, visitedCells)) {
                adjacentNewEarthCells.add(new GridCell(newRow, newColumn));
                visitedCells[newRow][newColumn] = true;
            }
        }
        return adjacentNewEarthCells;
    }

    private boolean isOutsideTheMap(int row, int column, int rowCount, int columnCount) {
        return (row < 0) || (row >= rowCount) ||
            (column < 0) || (column >= columnCount);
    }

    private boolean isNotVisitedEarthCell(int row, int column, char[][] grid, boolean[][] visitedCells) {
        return grid[row][column] == EARTH_CELL && !visitedCells[row][column];
    }

    private static class GridCell {
        private final int row;
        private final int column;

        public GridCell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
