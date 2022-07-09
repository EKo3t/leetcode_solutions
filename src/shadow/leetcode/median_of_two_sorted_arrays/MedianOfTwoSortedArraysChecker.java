package shadow.leetcode.median_of_two_sorted_arrays;

public class MedianOfTwoSortedArraysChecker {

    public static void main(String[] args) {
//        printSolutionResult(
//            new int[] {1, 3},
//            new int[] {2}
//        );

        printSolutionResult(
            new int[] {1, 2},
            new int[] {3, 4}
        );

        // 1, 3, 5, 6, 7 | 8, 9, 10, 11, 12
        printSolutionResult(
            new int[] {1, 3, 5, 7, 9, 11},
            new int[] {6, 8, 10, 12}
        );

        printSolutionResult(
            new int[] {1},
            new int[] {1}
        );

        // 1, 2, 3, 4, 5 | 6, 7, 8, 9, 11
        printSolutionResult(
            new int[] {5, 6, 7, 8, 9, 11},
            new int[] {1, 2, 3, 4}
        );

        // 1, 2, 3, 4, 5 | 6, 7, 8, 9, 11
        printSolutionResult(
            new int[] {8, 9, 11},
            new int[] {1, 2, 3, 4, 5, 6, 7}
        );

        printSolutionResult(
            new int[] {},
            new int[] {1, 2, 3, 4, 5, 6, 7}
        );

        printSolutionResult(
            new int[] {8, 9, 11},
            new int[] {}
        );

        printSolutionResult(
            new int[] {5, 5, 5, 5, 5},
            new int[] {4, 4, 4, 4, 4}
        );

        printSolutionResult(
            new int[] {5, 5, 5, 5, 5},
            new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5}
        );

        printSolutionResult(
            new int[] {4, 4, 4, 5, 5, 5, 5, 5},
            new int[] {5, 5, 5, 5, 5, 5, 5, 5, 5}
        );
    }

    private static void printSolutionResult(int[] nums1, int[] nums2) {
        var solution = new MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
