package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days">Task description</a>
 * Difficulty: medium
 */
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while (l < r) {
            int shipCapacity = (l + r) / 2;
            int minimumDaysWithShipCapacity = calculateDaysToShip(shipCapacity, weights);
            if (minimumDaysWithShipCapacity <= days) {
                r = shipCapacity;
            } else {
                l = shipCapacity + 1;
            }
        }
        return l;
    }

    private int calculateDaysToShip(int shipCapacity, int[] weights) {
        int currentSum = 0;
        int days = 0;
        for (int weight : weights) {
            currentSum += weight;
            if (currentSum > shipCapacity) {
                days++;
                currentSum = weight;
            }
        }
        return days + 1;
    }
}
