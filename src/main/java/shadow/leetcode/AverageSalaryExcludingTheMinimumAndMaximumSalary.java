package shadow.leetcode;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary">Task description</a>
 * Difficulty: easy
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public double average(int[] salaries) {
        int min = Arrays.stream(salaries).min().getAsInt();
        int max = Arrays.stream(salaries).max().getAsInt();
        return Arrays.stream(salaries)
            .filter(salary -> salary != min && salary != max).average().getAsDouble();
    }
}
