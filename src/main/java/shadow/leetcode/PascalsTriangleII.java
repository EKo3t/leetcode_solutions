package shadow.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/pascals-triangle-ii">Task description</a>
 * Difficulty: easy
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return Arrays.asList(1, 1);
        int[] prevValues = new int[rowIndex + 1];
        prevValues[0] = 1;
        prevValues[1] = 1;
        int[] currentValues = new int[rowIndex + 1];
        for (int i = 2; i <= rowIndex; i++) {
            currentValues[0] = 1;
            for (int j = 1; j < i; j++)
                currentValues[j] = prevValues[j - 1] + prevValues[j];
            currentValues[i] = 1;
            prevValues = Arrays.copyOfRange(currentValues, 0, rowIndex + 1);
        }
        return Arrays.stream(currentValues).boxed().toList();
    }
}
