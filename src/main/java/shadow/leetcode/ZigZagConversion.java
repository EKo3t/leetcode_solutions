package shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">Task description</a>
 * Difficulty: medium
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        List<ZigZagCharacter> zigZagCharacters = new ArrayList<>();
        int row = 0;
        int column = 0;
        boolean goesDown = true;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            zigZagCharacters.add(new ZigZagCharacter(currentChar, row, column));

            if (numRows > 1) {
                if ((row == numRows - 1) && goesDown) {
                    goesDown = false;
                }
                if (row == 0 && !goesDown) {
                    goesDown = true;
                }
                if (goesDown) row += 1;
                if (!goesDown) {
                    row -= 1;
                    column += 1;
                }
            } else column += 1;
        }
        sortZigZaggedCharacterByLocation(zigZagCharacters);
        StringBuilder sb = new StringBuilder();
        zigZagCharacters.forEach(zigZagCharacter -> sb.append(zigZagCharacter.value));
        return sb.toString();
    }

    private void sortZigZaggedCharacterByLocation(List<ZigZagCharacter> zigZagCharacters) {
        zigZagCharacters.sort((o1, o2) -> {
            if (o1.row < o2.row || o1.row == o2.row && o1.column < o2.column)
                return -1;
            if (o1.row == o2.row && o1.column == o2.column)
                return 0;
            return 1;
        });
    }

    private static class ZigZagCharacter {
        private final char value;
        private final int row;
        private final int column;

        public ZigZagCharacter(char value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }
    }
}
