package shadow.leetcode;

import java.util.Arrays;

public class FindOriginalArrayFromDoubled {

    public int[] findOriginalArray(int[] changed) {
        // for doubled arrays length must be even
        if (changed.length % 2 == 1) {
            return new int[0];
        }

        int counter = -1;
        int[] result = new int[changed.length / 2];

        Arrays.sort(changed);
        boolean[] filteredOutElements = new boolean[changed.length];
        for (int i = 0; i < changed.length; i++) {
            if (!filteredOutElements[i]) {
                result[++counter] = changed[i];
                filteredOutElements[i] = true;
                int x2Element = changed[i] * 2;
                // binary search for x2 element
                int l = i + 1;
                int r = changed.length - 1;
                while (l < r) {
                    int middle = (l + r) / 2;
                    if (changed[middle] > x2Element) {
                        r = middle - 1;
                    }
                    if (changed[middle] < x2Element || (changed[middle] == x2Element) && (filteredOutElements[middle])) {
                        l = middle + 1;
                    }
                    if ((changed[middle] == x2Element) && (!filteredOutElements[middle])) {
                        r = middle;
                    }
                    if ((changed[middle] == x2Element) && (filteredOutElements[middle])) {
                        l = middle + 1;
                    }
                }
                if ((l == r) && changed[l] == x2Element && !filteredOutElements[l]) {
                    filteredOutElements[l] = true;
                } else {
                    return new int[0];
                }
            }

        }
        return result;
    }

}
