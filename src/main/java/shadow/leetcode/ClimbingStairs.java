package shadow.leetcode;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int third = first + second;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
}
