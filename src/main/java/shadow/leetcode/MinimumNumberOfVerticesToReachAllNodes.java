package shadow.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes">Task description</a>
 * Difficulty: medium
 */
public class MinimumNumberOfVerticesToReachAllNodes {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> seenNodes = new HashSet<>();
        for (List<Integer> edge : edges)
            seenNodes.add(edge.get(1));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (!seenNodes.contains(i))
                result.add(i);

        return result;
    }
}
