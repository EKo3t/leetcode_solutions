package shadow.leetcode.add_two_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {

    @Test
    public void shouldSumCorrectly() {
        // all number are reversed like in the task
        long value1 = 243;
        long value2 = 564;
        long expected = 807;
        ListNode value1Node = convertToNodeAndReverse(value1);
        ListNode value2Node = convertToNodeAndReverse(value2);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode answer = solution.addTwoNumbers(value1Node, value2Node);
        Assertions.assertTrue(isEquals(answer, convertToNodeAndReverse(expected)));
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

    private boolean isEquals(ListNode actual, ListNode expected) {
        var iteratorForActual = actual;
        var iteratorForExpected = expected;
        while (iteratorForActual != null) {
            if (iteratorForExpected == null) {
                return false;
            }
            if (iteratorForActual.val != iteratorForExpected.val)
                return false;

            iteratorForActual = iteratorForActual.next;
            iteratorForExpected = iteratorForExpected.next;
        }
        return iteratorForExpected == null;
    }
}
