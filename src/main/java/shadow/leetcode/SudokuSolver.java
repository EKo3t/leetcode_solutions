package shadow.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.highestOneBit;
import static java.lang.Integer.numberOfTrailingZeros;

public class SudokuSolver {

    private final static short ALL_BITS = 0b1111111110;

    public void solveSudoku(char[][] board) {
        short[] rowValues = new short[9];
        short[] columnValues = new short[9];
        short[] squareValues = new short[9];
        Arrays.fill(rowValues, (short) 0);
        Arrays.fill(columnValues, (short) 0);
        Arrays.fill(squareValues, (short) 0);

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] != '.') {
                    byte value = (byte) (board[i][j] - '0');
                    rowValues[i] |= 1 << value;
                    columnValues[j] |= 1 << value;
                    squareValues[getSquareIndex(i, j)] |= 1 << value;
                }

        var usedDigits = new short[9][9];
        var cellChoices = new CellValueToSet[9][9];
        var valuesToSetInCells = getPossibleValuesToInsert(board, rowValues, columnValues, squareValues);
        for (CellValueToSet valuesToSetInCell : valuesToSetInCells) {
            var position = valuesToSetInCell.position;
            cellChoices[position.row][position.column] = valuesToSetInCell;
        }
        var processedCells = new LinkedList<CellValueToSet>();
        List<CellChoice>[][] transactionMatrix = new List[9][9];
        while (!valuesToSetInCells.isEmpty()) {
            var currentCell = valuesToSetInCells.poll();
            int currentRow = currentCell.position.row;
            int currentColumn = currentCell.position.column;

            short setBits = (short) (currentCell.bits ^ usedDigits[currentCell.position.row][currentCell.position.column]);
            if (setBits == 0) {
                usedDigits[currentRow][currentColumn] = 0;
                if (transactionMatrix[currentRow][currentColumn] != null)
                    rollbackLastTransaction(transactionMatrix[currentRow][currentColumn], cellChoices, valuesToSetInCells);
                valuesToSetInCells.add(currentCell);
            }

            // Add operations
            // this is our digit in fact
            var highestBit = highestOneBit(setBits);
            byte highestBitOrder = (byte) numberOfTrailingZeros(highestBit);

            usedDigits[currentRow][currentColumn] |= highestBit;
            board[currentRow][currentColumn] = (char) (highestBitOrder + '0');
            var removedChoices = getRemovedChoicesAfterSetDigit(highestBitOrder, currentCell.position, cellChoices, valuesToSetInCells);
            transactionMatrix[currentRow][currentColumn] = removedChoices;
            processedCells.add(currentCell);
        }
    }

    private List<CellChoice> getRemovedChoicesAfterSetDigit(
        byte digit,
        Position position,
        CellValueToSet[][] cellChoices,
        PriorityQueue<CellValueToSet> valuesToSetInCells
    ) {
        List<CellChoice> removedChoices = new ArrayList<>();

        for (int i = 0; i < 9; i++)
            if ((cellChoices[position.row][i] != null && i != position.column && (cellChoices[position.row][i].bits & (1 << digit)) != 0))
                removeChoice(digit, valuesToSetInCells, removedChoices, cellChoices[position.row][i]);
        for (int i = 0; i < 9; i++)
            if ((cellChoices[i][position.column] != null && i != position.row && (cellChoices[i][position.column].bits & (1 << digit)) != 0))
                removeChoice(digit, valuesToSetInCells, removedChoices, cellChoices[i][position.column]);

        int squareIndex = getSquareIndex(position.row, position.column);
        int startSquareRow = squareIndex / 3 * 3;
        int startSquareColumn = squareIndex % 3 * 3;
        for (int i = startSquareRow; i < startSquareRow + 3; i++)
            for (int j = startSquareColumn; j < startSquareColumn + 3; j++)
                if ((cellChoices[i][j] != null && ((i != position.row) || (j != position.column)) && (cellChoices[i][j].bits & (1 << digit)) != 0))
                removeChoice(digit, valuesToSetInCells, removedChoices, cellChoices[i][j]);
        return removedChoices;
    }

    private void removeChoice(byte highestBitOrder, PriorityQueue<CellValueToSet> valuesToSetInCells, List<CellChoice> removedChoices, CellValueToSet currentChoice) {
        currentChoice.bits &= ~(1 << highestBitOrder);
        valuesToSetInCells.remove(currentChoice);
        valuesToSetInCells.add(currentChoice);
        removedChoices.add(new CellChoice(highestBitOrder, currentChoice.position));
    }

    private void rollbackLastTransaction(List<CellChoice> choicesToRollback, CellValueToSet[][] cellChoices, PriorityQueue<CellValueToSet> valuesToSetInCells) {
        for (CellChoice toRollback : choicesToRollback) {
            var affectedCell = cellChoices[toRollback.position.row][toRollback.position.column];
            affectedCell.bits |= 1 << toRollback.value;
            valuesToSetInCells.remove(affectedCell);
            valuesToSetInCells.add(affectedCell);
        }
    }

    private PriorityQueue<CellValueToSet> getPossibleValuesToInsert(
        char[][] board,
        short[] rowValues,
        short[] columnValues,
        short[] squareValues
    ) {
        PriorityQueue<CellValueToSet> cellValueToSets = new PriorityQueue<>(Comparator.comparingInt(o -> bitCount(o.bits)));

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == '.') {
                    short result = (short) (ALL_BITS ^ (rowValues[i] | columnValues[j] | squareValues[getSquareIndex(i, j)]));

                    cellValueToSets.add(new CellValueToSet(result, new Position(i, j)));
                }

        return cellValueToSets;
    }

    private int getSquareIndex(int row, int column) {
        return (row / 3) * 3 + (column / 3);
    }

    private static final class CellValueToSet {
        private short bits;
        private final Position position;

        private CellValueToSet(short bits, Position position) {
            this.bits = bits;
            this.position = position;
        }
    }

    private record Position(int row, int column) {
    }

    private record CellChoice(byte value, Position position) {
    }
}
