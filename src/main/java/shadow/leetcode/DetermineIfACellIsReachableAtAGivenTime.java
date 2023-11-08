package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time">Task description</a>
 * Difficulty: Medium
 */
public class DetermineIfACellIsReachableAtAGivenTime {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1)
            return false;
        int minimumTimeToReach = Integer.max(Math.abs(fx - sx), Math.abs(fy - sy));
        return minimumTimeToReach <= t;
    }
}
