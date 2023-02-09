package shadow.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @see <a href="https://leetcode.com/problems/naming-a-company">Task description</a>
 * Difficulty: hard
 */
public class NamingACompany {

    public long distinctNames(String[] ideas) {
        Set<Integer>[] suffixByCapital = new HashSet[26];
        for (int i = 0; i < 26; i++)
            suffixByCapital[i] = new HashSet<>();
        for (int i = 0; i < ideas.length; i++) {
            String idea = ideas[i];
            suffixByCapital[idea.charAt(0) - 'a'].add(idea.substring(1).hashCode());
        }

        long result = 0;

        for (int i = 0; i < 26; i++)
            if (suffixByCapital[i].size() != 0)
                for (int j = i + 1; j < 26; j++)
                    if (suffixByCapital[j].size() != 0)
                        result += (long) returnSet1WithoutIntersection(suffixByCapital[i], suffixByCapital[j]).size()
                            * returnSet1WithoutIntersection(suffixByCapital[j], suffixByCapital[i]).size()
                            * 2;


        return result;
    }

    private <T> Set<T> returnSet1WithoutIntersection(Set<T> set1, Set<T> set2) {
        Set<T> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        Set<T> result = new HashSet<>(set1);
        result.removeAll(intersection);
        return result;
    }
}