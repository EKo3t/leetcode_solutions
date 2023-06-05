package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/check-if-it-is-a-straight-line">Task description</a>
 * Difficulty: easy
 */
public class CheckIfItIsAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int a = coordinates[0][1] - coordinates[1][1];
        int b = coordinates[1][0] - coordinates[0][0];
        int c = coordinates[0][0] * coordinates[1][1] - coordinates[1][0] * coordinates[0][1];

        return Arrays.stream(coordinates).allMatch(coordinate -> a * coordinate[0] + b * coordinate[1] + c == 0);
    }
}
