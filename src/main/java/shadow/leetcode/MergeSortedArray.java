package shadow.leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int iterator1 = 0;
        int iterator2 = 0;
        int counter = -1;
        while (iterator1 < m && iterator2 < n) {
            if (nums1Copy[iterator1] < nums2[iterator2]) {
                nums1[++counter] = nums1Copy[iterator1];
                iterator1 += 1;
            } else {
                nums1[++counter] = nums2[iterator2];
                iterator2 += 1;
            }
        }
        if (iterator1 == m) {
            for (int i = iterator2; i < n; i++)
                nums1[++counter] = nums2[i];
        }
        if (iterator2 == n) {
            for (int i = iterator1; i < m; i++)
                nums1[++counter] = nums1Copy[i];
        }
    }
}
