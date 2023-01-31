package shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle">Task description</a>
 * Difficulty: easy
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        if (numRows == 1) return result;
        result.add(List.of(1, 1));
        if (numRows == 2) return result;
        for (int i = 2; i < numRows; i++) {
            result.add(new ArrayList<>());
            List<Integer> row = result.get(i);
            row.add(1);
            List<Integer> previousRow = result.get(i - 1);
            for (int j = 1; j < i; j++)
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            row.add(1);
        }
        return result;
    }
}
