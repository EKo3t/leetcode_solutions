package shadow.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @see <a href="https://leetcode.com/problems/fruit-into-baskets/">Task description</a>
 * Difficulty: medium
 */
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> types = new HashMap<>();
        int l = 0;
        int r = 0;
        types.compute(fruits[r], (k, v) -> 1);
        int max = 0;
        while (true) {
            if (types.keySet().size() <= 2) {
                max = Integer.max(max, r - l + 1);
                if (r < fruits.length - 1)
                    types.compute(fruits[++r], (k, v) -> (v != null ? v : 0) + 1);
                else break;
            } else {
                if (types.get(fruits[l]) == 1)
                    types.remove(fruits[l++]);
                else
                    types.compute(fruits[l++], (k, v) -> v - 1);
            }
        }
        return max;
    }
}
