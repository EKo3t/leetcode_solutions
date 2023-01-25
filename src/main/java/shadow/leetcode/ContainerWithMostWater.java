package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">Task description</a>
 * Difficulty: medium
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxContainer = 0;
        while (l < r) {
            int currentContainer = Math.min(height[l], height[r]) * (r - l);
            maxContainer = Math.max(currentContainer, maxContainer);

            if (height[l] < height[r])
                l += 1;
            else if (height[l] > height[r])
                r -= 1;
            else {
                l++;
                r--;
            }
        }
        return maxContainer;
    }
}
