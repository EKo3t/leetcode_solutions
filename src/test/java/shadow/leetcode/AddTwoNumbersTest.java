package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shadow.leetcode.util.IntListNode;

public class AddTwoNumbersTest {

    @Test
    public void shouldSumCorrectly() {
        // all number are reversed like in the task
        long value1 = 243;
        long value2 = 564;
        long expected = 807;
        IntListNode value1Node = convertToNodeAndReverse(value1);
        IntListNode value2Node = convertToNodeAndReverse(value2);

        AddTwoNumbers solution = new AddTwoNumbers();
        IntListNode answer = solution.addTwoNumbers(value1Node, value2Node);
        Assertions.assertTrue(isEquals(answer, convertToNodeAndReverse(expected)));
    }

    private static IntListNode convertToNodeAndReverse(long value) {
        IntListNode root = new IntListNode();
        IntListNode lastDigitNode = root;
        while (value > 0) {
            long modulo = value % 10;
            IntListNode currentNode = new IntListNode((int) modulo);
            lastDigitNode.next = currentNode;
            lastDigitNode = currentNode;
            value = value / 10;
        }
        return root.next;
    }

    private boolean isEquals(IntListNode actual, IntListNode expected) {
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
