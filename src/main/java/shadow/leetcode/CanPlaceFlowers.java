package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/can-place-flowers">Task description</a>
 * Difficulty: easy
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int placedFlowers = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i - 1 < 0 || flowerbed[i - 1] == 0) && (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0)) {
                placedFlowers += 1;
                if (placedFlowers == n)
                    return true;
                flowerbed[i] = 1;
            }
        }
        return false;
    }
}
