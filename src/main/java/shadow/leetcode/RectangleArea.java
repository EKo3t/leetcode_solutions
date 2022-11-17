package shadow.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/rectangle-are">Task description</a>
 * Difficulty: medium
 */
public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        if (ax1 > ax2) {
            int temp = ax1;
            ax1 = ax2;
            ax2 = temp;
        }
        if (ay1 > ay2) {
            int temp = ay1;
            ay1 = ay2;
            ay2 = temp;
        }
        if (bx1 > bx2) {
            int temp = bx1;
            bx1 = bx2;
            bx2 = temp;
        }
        if (by1 > by2) {
            int temp = by1;
            by1 = by2;
            by2 = temp;
        }

        int square1 = (ax2 - ax1) * (ay2 - ay1);
        int square2 = (bx2 - bx1) * (by2 - by1);
        int firstIntersectionSide = 0;
        int secondIntersectionSide = 0;

        if (ax1 <= bx1 && bx1 < ax2) {
            firstIntersectionSide = bx2 <= ax2 ? (bx2 - bx1) : (ax2 - bx1);
        }
        if (bx1 <= ax1 && ax1 < bx2) {
            firstIntersectionSide = ax2 <= bx2 ? (ax2 - ax1) : (bx2 - ax1);
        }

        if (ay1 <= by1 && by1 < ay2) {
            secondIntersectionSide = by2 <= ay2 ? (by2 - by1) : (ay2 - by1);
        }
        if (by1 <= ay1 && ay1 < by2) {
            secondIntersectionSide = ay2 <= by2 ? (ay2 - ay1) : (by2 - ay1);
        }

        int intersection = firstIntersectionSide * secondIntersectionSide;
        return square1 - intersection + square2;
    }
}
