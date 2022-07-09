package shadow.leetcode.median_of_two_sorted_arrays;

/**
 * @see <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">Java Dcoumentation</a>
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean isOddMedian = (len1 + len2) % 2 == 1;

        // optimization if one of arrays is empty
        if (len1 == 0) {
            return isOddMedian ? nums2[len2 / 2] : (double) (nums2[len2 / 2 - 1] + nums2[len2 / 2]) / 2;
        }

        if (len2 == 0) {
            return isOddMedian ? nums1[len1 / 2] : (double) (nums1[len1 / 2 - 1] + nums1[len1 / 2]) / 2;
        }

        if (len1 > len2) {
            int[] swap = nums1;
            nums1 = nums2;
            nums2 = swap;
            len1 = len1 + len2;
            len2 = len1 - len2;
            len1 = len1 - len2;
        }

        int left = 0;
        int medianIndex = (len1 + len2 - 1) / 2;
        int right = nums1.length - 1;
        while (left <= right) {
            int num1RightIndex = (left + right) / 2;
            int num2RightIndex = medianIndex - num1RightIndex - 1; // arrays start from 0, -1 for each one.
            boolean nextNums1ElementExists = num1RightIndex + 1 < nums1.length;
            boolean nextNums2ElementExists = num2RightIndex + 1 < nums2.length;
            if (nextNums1ElementExists && nums2[num2RightIndex] > nums1[num1RightIndex + 1]
            || !nextNums1ElementExists && nums2[num2RightIndex] > nums1[num1RightIndex]) {
                left = num1RightIndex + 1;
                continue;
            }
            if (nextNums2ElementExists && nums1[num1RightIndex] > nums2[num2RightIndex + 1]) {
                right = num1RightIndex - 1;
                continue;
            }

            // we found num1RightIndex and num2RightIndex. We need to calculate median elements.
            // They are next elements of right index. But some elements can be non-existent and median can be odd
            if (isOddMedian) {
                return Integer.max(nums1[num1RightIndex], nums2[num2RightIndex]);
            } else {
                return (double) (nums1[num1RightIndex] + nums2[num2RightIndex]) / 2;
            }
        }
        if (right < 0) {
            // left > right it means that first array doesn't participate in finding median.
            return isOddMedian ? nums2[medianIndex]
                : (double) (nums2[medianIndex] + nums2[medianIndex - 1]) / 2;
        }
        if (left >= len1) {
            return isOddMedian ? nums2[medianIndex - len1]
                : (double) (nums2[medianIndex - len1] + nums2[medianIndex - len1 - 1]) / 2;
        }
        return 0;
    }
    // 1 3 5 6 7 | 8 9 10 11 12

    // 1 2 3 4
    // 5 6 7 8 9 10 11 12
    // 1 2 3 4 5 6 | 7 8 9 10 11 12
}
