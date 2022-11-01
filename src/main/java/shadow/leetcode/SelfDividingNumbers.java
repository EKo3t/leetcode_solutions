package shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int number = i;
            boolean isSelfDividing = true;
            while (number > 0) {
                int mod10 = number % 10;
                if (mod10 == 0 || i % mod10 != 0) {
                    isSelfDividing = false;
                    break;
                }
                number /= 10;
            }
            if (isSelfDividing) {
                result.add(i);
            }
        }
        return result;
    }
}
