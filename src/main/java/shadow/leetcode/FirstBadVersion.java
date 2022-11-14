package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">Task description</a>
 * Difficulty: medium
 */
public class FirstBadVersion {

    private final int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;

        while (l != r) {
            int middle = l / 2 + r / 2 + (r % 2 == 1 && l % 2 == 1 ? 1 : 0);
            if (!isBadVersion(middle))
                l = middle + 1;
            else
                r = middle;
        }
        return l;
    }

    private boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}
