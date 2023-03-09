package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class LinkedListCycleIITest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode node, IntListNode hasCycle) {
        var objectUnderTest = new LinkedListCycleII();
        Assertions.assertEquals(hasCycle, objectUnderTest.detectCycle(node));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(createArguments(new int[]{3, 2, 0, -4}, 1)),
            Arguments.of(createArguments(new int[]{1, 2}, 0)),
            Arguments.of(createArguments(new int[]{1}, -1))
        );
    }

    private static Object[] createArguments(int[] initialArray, int cyclePosition) {
        if (cyclePosition == -1) {
            return new Object[]{ListNodes.convert(initialArray), null};
        }
        var root = createCycle(ListNodes.convert(initialArray), cyclePosition);
        var cyclePoint = iterate(root, cyclePosition);
        return new Object[]{root, cyclePoint};
    }

    private static IntListNode iterate(IntListNode root, int index) {
        var current = root;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    private static IntListNode createCycle(IntListNode listNode, int cycleStartPosition) {
        int counter = 0;
        IntListNode iterator = listNode;
        IntListNode cycleStartNode = null;
        while (iterator.next != null) {
            if (cycleStartPosition == counter) {
                cycleStartNode = iterator;
            }
            counter++;
            iterator = iterator.next;
        }
        iterator.next = cycleStartNode;
        if (cycleStartNode == null) {
            throw new IllegalArgumentException("Cycle start position is out of the bound");
        }
        return listNode;
    }
}
