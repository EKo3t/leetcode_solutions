package shadow.leetcode;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][][] squares = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    short digit = (short) (board[i][j] - '1');
                    if (rows[i][digit]) {
                        return false;
                    }
                    rows[i][digit] = true;
                    if (columns[j][digit]) {
                        return false;
                    }
                    columns[j][digit] = true;
                    if (squares[i / 3][j / 3][digit]) {
                        return false;
                    }
                    squares[i / 3][j / 3][digit] = true;
                }
            }
        }
        return true;
    }
}
