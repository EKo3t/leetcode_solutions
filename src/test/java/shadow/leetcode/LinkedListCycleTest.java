package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class LinkedListCycleTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode node, boolean hasCycle) {
        var objectUnderTest = new LinkedListCycle();
        Assertions.assertEquals(hasCycle, objectUnderTest.hasCycle(node));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(createCycle(ListNodes.convert(new int[] {3,2,0,-4}), 1), true),
            Arguments.of(createCycle(ListNodes.convert(new int[] {1,2}), 0), true),
            Arguments.of(ListNodes.convert(new int[] {1}), false)
        );
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
