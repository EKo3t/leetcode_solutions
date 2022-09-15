package shadow.leetcode.util;

import java.util.*;

public final class Collections {

    public static boolean hasTheSameElements(List<String> strings1, List<String> strings2) {
        Set<String> strings1Set = new HashSet<>(strings1);

        for (String s : strings2) {
            if (!strings1Set.remove(s)) {
                return false;
            }
        }
        return strings1Set.isEmpty();
    }

    public static <T> List<T> newArrayList(T... elements) {
        return new ArrayList<>(Arrays.asList(elements));
    }
}
