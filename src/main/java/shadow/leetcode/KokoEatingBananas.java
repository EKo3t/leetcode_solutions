package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas">Task description</a>
 * Difficulty: medium
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int r = maxPile;
        while (l < r) {
            int mid = (l + r) / 2;
            int hours = getHoursToEat(piles, mid);
            if (hours > h)
                l = mid + 1;
            if (hours <= h)
                r = mid;
        }
        return l;
    }

    private int getHoursToEat(int[] foodAmounts, int eatSpeed) {
        return Arrays.stream(foodAmounts)
            .map(foodAmount -> foodAmount / eatSpeed + (foodAmount % eatSpeed != 0 ? 1 : 0))
            .sum();
    }
}
