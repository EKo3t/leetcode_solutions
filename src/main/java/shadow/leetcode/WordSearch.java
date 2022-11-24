package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/word-search/">Task description</a>
 * Difficulty: medium
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (iterateCellLetter(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean iterateCellLetter(int row, int column, char[][] board, String word, int letterIndex) {
        if (letterIndex == word.length() - 1) {
            return true;
        }
        char temp = board[row][column];
        board[row][column] = '.';
        if (row - 1 >= 0 && board[row - 1][column] == word.charAt(letterIndex + 1) &&
            iterateCellLetter(row - 1, column, board, word, letterIndex + 1)) {
            return true;
        }

        if (column + 1 < board[row].length && board[row][column + 1] == word.charAt(letterIndex + 1) &&
            iterateCellLetter(row, column + 1, board, word, letterIndex + 1)) {
            return true;
        }

        if (row + 1 < board.length && board[row + 1][column] == word.charAt(letterIndex + 1) &&
            iterateCellLetter(row + 1, column, board, word, letterIndex + 1)) {
            return true;
        }

        if (column - 1 >= 0 && board[row][column - 1] == word.charAt(letterIndex + 1) &&
            iterateCellLetter(row, column - 1, board, word, letterIndex + 1)) {
            return true;
        }

        board[row][column] = temp;
        return false;
    }
}
