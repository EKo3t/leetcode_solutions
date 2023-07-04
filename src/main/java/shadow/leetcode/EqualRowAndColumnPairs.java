package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/equal-row-and-column-pairs">Task description</a>
 * Difficulty: medium
 */
public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> columns = new HashMap<>();

        for (int i = 0; i < grid.length; i++) rows.compute(calculateHash(grid, i, true), (k, v) -> v == null ? 1 : v + 1);
        for (int i = 0; i < grid[0].length; i++) columns.compute(calculateHash(grid, i, false), (k, v) -> v == null ? 1 : v + 1);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : rows.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            count += v * columns.getOrDefault(k, 0);
        }
        return count;
    }

    private int calculateHash(int[][] grid, int index, boolean isRow) {
        int upperValue = isRow ? grid.length : grid[0].length;
        int hash = 0;
        for (int i = 0; i < upperValue; i++) {
            hash = (hash * 93 + grid[isRow ? index : i][isRow ? i : index]) % 573921548;
        }
        return hash;
    }
}
