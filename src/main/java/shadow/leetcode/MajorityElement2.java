package shadow.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> elements = new HashSet<>();
        int size = nums.length;

        Map<Integer, Integer> countByNumber = new HashMap<>();
        for (int num : nums) {
            countByNumber.compute(num, (key, value) ->
                Optional.ofNullable(value).orElse(0) + 1
            );
            if (countByNumber.get(num) > size / 3)
                elements.add(num);
        }

        return new ArrayList<>(elements);
    }
}
