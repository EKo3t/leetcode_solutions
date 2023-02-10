package shadow.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @see <a href="https://leetcode.com/problems/as-far-from-land-as-possible">Task description</a>
 * Difficulty: medium
 */
public class AsFarFromLandAsPossible {

    private static final int[] DELTA_Y = new int[] {-1, 0, 1, 0};
    private static final int[] DELTA_X = new int[] {0, 1, 0, -1};

    public int maxDistance(int[][] grid) {
        int size = grid.length;
        int[][] minDistancesFrom1ToCell = new int[grid.length][grid.length];
        for (int i = 0; i < size; i++)
            Arrays.fill(minDistancesFrom1ToCell[i], 300);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == 1) {
                    LinkedList<CellDistance> cellDistances = new LinkedList<>();
                    cellDistances.add(CellDistance.from(i, j, 0));
                    while (!cellDistances.isEmpty()) {
                        CellDistance toProcess = cellDistances.pollFirst();
                        for (int k = 0; k < 4; k++) {
                            CellDistance visitedCell = CellDistance.from(
                                toProcess.row + DELTA_Y[k],
                                toProcess.column + DELTA_X[k],
                                toProcess.distance + 1);
                            int row = visitedCell.row;
                            int column = visitedCell.column;
                            if (isInsideBounds(visitedCell, size) && grid[row][column] == 0
                                && visitedCell.distance < minDistancesFrom1ToCell[row][column]) {
                                minDistancesFrom1ToCell[row][column] = visitedCell.distance;
                                cellDistances.add(visitedCell);
                            }
                        }
                    }
                }

        int maxDistance = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j] == 0 && minDistancesFrom1ToCell[i][j] > maxDistance)
                    maxDistance = minDistancesFrom1ToCell[i][j];

        return maxDistance == 0 || maxDistance == 300 ? -1 : maxDistance;
    }

    private boolean isInsideBounds(CellDistance distance, int size) {
        int row = distance.row;
        int column = distance.column;
        return row > - 1 && row < size && column > -1 && column < size;
    }

    private static class CellDistance {
        private final int row;
        private final int column;
        private final int distance;

        private static CellDistance from(int row, int column, int distance) {
            return new CellDistance(row, column, distance);
        }

        private CellDistance(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }
}
