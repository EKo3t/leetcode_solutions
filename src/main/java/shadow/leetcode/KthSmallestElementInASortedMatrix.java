package shadow.leetcode;

import java.util.PriorityQueue;

/**
 * @see <a href="https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/">Task description</a>
 * Difficulty: medium
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatrixElement> smallestElementQueue = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            smallestElementQueue.add(new MatrixElement(ints[0], i, 0));
        }

        int counter = 1;
        while (counter < k) {
            MatrixElement smallestInQueue = smallestElementQueue.poll();
            if (smallestInQueue.column < matrix[smallestInQueue.row].length - 1) {
                int nextColumn = smallestInQueue.column + 1;
                smallestElementQueue.add(
                    new MatrixElement(matrix[smallestInQueue.row][nextColumn], smallestInQueue.row, nextColumn)
                );
            }
            counter++;
        }
        return smallestElementQueue.poll().value;
    }

    private static final class MatrixElement implements Comparable<MatrixElement> {
        private final int value;
        private final int row;
        private final int column;

        private MatrixElement(int value, int row, int column) {
            this.value = value;
            this.row = row;
            this.column = column;
        }

        @Override
        public int compareTo(MatrixElement o) {
            return Integer.compare(this.value, o.value);
        }
    }
}
