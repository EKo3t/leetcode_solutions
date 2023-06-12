package shadow.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/summary-ranges">Task description</a>
 * Difficulty: easy
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        int rangeStart = Integer.MIN_VALUE;
        int rangeEnd = Integer.MIN_VALUE;
        int ranges = 0;
        for (int num : nums) {
            if (num != rangeEnd + 1 || ranges == 0) {
                if (ranges > 0)
                    result.add(rangeStart + (rangeStart != rangeEnd ? "->" + rangeEnd : ""));
                ranges++;
                rangeStart = num;
                rangeEnd = num;
            } else
                rangeEnd++;
        }
        if (ranges > result.size()) result.add(rangeStart + (rangeStart != rangeEnd ? "->" + rangeEnd : ""));
        return result;
    }
}
