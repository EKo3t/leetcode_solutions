package shadow.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/insert-interval">Task description</a>
 * Difficulty: medium
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<Interval> merged = new LinkedList<>();
        boolean inserted = false;

        for (int[] ints : intervals) {
            if (!inserted && newInterval[0] < ints[0]) {
                merged.add(new Interval(newInterval[0], newInterval[1]));
                inserted = true;
            }
            if (inserted)
                mergeIntervals(merged);
            merged.add(new Interval(ints[0], ints[1]));
        }
        if (!inserted) {
            merged.add(new Interval(newInterval[0], newInterval[1]));
        }
        mergeIntervals(merged);
        List<int[]> asList = merged.stream().map(interval -> new int[]{interval.start, interval.end}).toList();
        return asList.toArray(new int[0][2]);
    }

    private void mergeIntervals(LinkedList<Interval> merged) {
        while (merged.size() > 1) {
            Interval last = merged.pollLast();
            Interval beforeLast = merged.pollLast();

            assert beforeLast != null;
            if (beforeLast.end >= last.start) {
                Interval mergedInterval = new Interval(beforeLast.start, Integer.max(beforeLast.end, last.end));
                merged.add(mergedInterval);
            } else {
                merged.add(beforeLast);
                merged.add(last);
                break;
            }
        }
    }

    private static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
