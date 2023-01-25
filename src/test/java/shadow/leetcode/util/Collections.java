package shadow.leetcode.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static <T extends Comparable<T>> boolean areEqual(T[] array, List<T> elements) {
        if (array.length != elements.size())
            return false;

        List<T> sorted = elements.stream().sorted().toList();
        Arrays.sort(array);

        for (int i = 0; i < sorted.size(); i++)
            if (!sorted.get(i).equals(array[i]))
                return false;

        return true;
    }

    public static <T extends Comparable<T>> boolean areEqual(List<T> expected, List<T> elements) {
        if (expected == null && elements == null)
            return true;

        if (expected == null || elements == null)
            return false;

        if (expected.size() != elements.size())
            return false;

        List<T> sorted = elements.stream().sorted().toList();
        List<T> sortedExpected = expected.stream().sorted().toList();

        for (int i = 0; i < sorted.size(); i++)
            if (!sorted.get(i).equals(sortedExpected.get(i)))
                return false;

        return true;
    }
}
