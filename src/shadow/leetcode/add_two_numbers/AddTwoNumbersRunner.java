package shadow.leetcode.add_two_numbers;

public class AddTwoNumbersRunner {
    // do not copy code below into solution
    public static void main(String[] args) {
        long value1 = 243;
        long value2 = 564;
        ListNode value1Node = convertToNodeAndReverse(value1);
        ListNode value2Node = convertToNodeAndReverse(value2);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode node = solution.addTwoNumbers(value1Node, value2Node);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode convertToNodeAndReverse(long value) {
        ListNode root = new ListNode();
        ListNode lastDigitNode = root;
        while (value > 0) {
            long modulo = value % 10;
            ListNode currentNode = new ListNode((int) modulo);
            lastDigitNode.next = currentNode;
            lastDigitNode = currentNode;
            value = value / 10;
        }
        return root.next;
    }

}
