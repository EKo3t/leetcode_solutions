package shadow.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/">Task description</a>
 * Difficulty: hard
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        LinkedList<Integer> braces = new LinkedList<>();
        List<Range> validRanges = new ArrayList<>();
        char[] chars = s.toCharArray();
        int maximumLongestValidLength = 0;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar == '(') {
                braces.add(i);
            }
            if (aChar == ')') {
                Integer indexOfOpenedParenthesis = braces.pollLast();
                if (indexOfOpenedParenthesis != null) {
                    Range validRange = getRange(i, indexOfOpenedParenthesis);
                    shiftAndMergeRanges(validRanges, validRange);
                    int maxRange = validRanges.stream().max(Comparator.comparingInt(Range::getLength)).get().getLength();
                    maximumLongestValidLength = Integer.max(maximumLongestValidLength, maxRange);
                }
            }
        }
        return maximumLongestValidLength;
    }

    private void shiftAndMergeRanges(List<Range> validRanges, Range validRange) {
        if (validRanges.isEmpty()) {
            validRanges.add(validRange);
        } else {
            int lastIndex = validRanges.size() - 1;
            if (shouldBeMerged(validRanges.get(lastIndex), validRange)) {
                validRanges.set(lastIndex, merge(validRanges.get(lastIndex), validRange));
            } else
                validRanges.add(validRange);
        }
        for (int i = validRanges.size() - 2; i >= 0; i--) {
            if (shouldBeMerged(validRanges.get(i + 1), validRanges.get(i))) {
                validRanges.set(i, merge(validRanges.get(i + 1), validRanges.get(i)));
                validRanges.remove(i + 1);
            } else
                break;
        }
    }

    private Range getRange(int i, Integer peekLast) {
        return new Range(peekLast, i);
    }

    private boolean shouldBeMerged(Range range1, Range range2) {
        if (range1.start > range2.start) {
            var temp = range1;
            range1 = range2;
            range2 = temp;
        }
        return range2.start <= range1.end + 1;
    }

    private Range merge(Range range1, Range range2) {
        return new Range(Integer.min(range1.start, range2.start), Integer.max(range1.end, range2.end));
    }

    private static class Range {

        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getLength() {
            return end - start + 1;
        }
    }
}
