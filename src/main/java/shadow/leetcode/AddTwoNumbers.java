package shadow.leetcode;

import shadow.leetcode.util.IntListNode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Task description</a>
 * Difficulty: medium
 */
class AddTwoNumbers {

    public IntListNode addTwoNumbers(IntListNode l1, IntListNode l2) {
        IntListNode root = new IntListNode();
        IntListNode lastSumDigitNode = root;
        IntListNode currentL1Node = l1;
        IntListNode currentL2Node = l2;
        byte plus1FromPreviousDigitSum = 0;
        while (currentL1Node != null || currentL2Node != null || plus1FromPreviousDigitSum == 1) {
            byte sum = getCurrentDigitSum(currentL1Node, currentL2Node, plus1FromPreviousDigitSum);

            if (sum > 9) {
                sum -= 10;
                plus1FromPreviousDigitSum = 1;
            } else
                plus1FromPreviousDigitSum = 0;

            IntListNode currentSumDigitNode = new IntListNode(sum);
            lastSumDigitNode.next = currentSumDigitNode;
            lastSumDigitNode = currentSumDigitNode;
            if (currentL1Node != null) currentL1Node = currentL1Node.next;
            if (currentL2Node != null) currentL2Node = currentL2Node.next;
        }
        return root.next;
    }

    private byte getCurrentDigitSum(IntListNode l1, IntListNode l2, byte plus1FromPreviousDigitSum) {
        byte currentL1Digit = l1 == null ? 0 : (byte) l1.val;
        byte currentL2Digit = l2 == null ? 0 : (byte) l2.val;
        return (byte) (currentL1Digit + currentL2Digit + plus1FromPreviousDigitSum);
    }
}
