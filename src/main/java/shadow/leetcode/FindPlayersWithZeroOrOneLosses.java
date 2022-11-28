package shadow.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/find-players-with-zero-or-one-losses/">Task description</a>
 * Difficulty: medium
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> notLost = new HashSet<>();
        Set<Integer> lostOne = new HashSet<>();
        Set<Integer> lostMore = new HashSet<>();

        for (int[] match : matches) {
            boolean isLostOnce = false;
            if (!lostOne.contains(match[0]) && !lostMore.contains(match[0])) {
                notLost.add(match[0]);
            }

            if (notLost.contains(match[1]) || !notLost.contains(match[1]) && !lostOne.contains(match[1]) && !lostMore.contains(match[1])) {
                notLost.remove(match[1]);
                isLostOnce = true;
            }
            if (isLostOnce) {
                lostOne.add(match[1]);
            } else {
                lostOne.remove(match[1]);
                lostMore.add(match[1]);
            }
        }
        return List.of(notLost.stream().sorted().toList(), lostOne.stream().sorted().toList());
    }
}
