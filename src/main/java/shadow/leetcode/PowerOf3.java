package shadow.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/power-of-three/">Task description</a>
 * Difficulty: easy
 */
public class PowerOf3 {

    private static final Set<Integer> POWERS_OF_3 = new HashSet<>();

    static {
        int currentPowerOf3 = 1;
        POWERS_OF_3.add(currentPowerOf3);
        while (Integer.MAX_VALUE / currentPowerOf3 >= 3) {
            currentPowerOf3 *= 3;
            POWERS_OF_3.add(currentPowerOf3);
        }
    }

    public boolean isPowerOfThree(int n) {
        return n >= 1 && POWERS_OF_3.contains(n);
    }
}
