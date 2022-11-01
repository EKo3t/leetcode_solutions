package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeKSortedListsTest {

    private static final MergeKSortedLists SOLUTION = new MergeKSortedLists();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(IntListNode[] lists, IntListNode expected) {
        Assertions.assertTrue(areEqual(expected, SOLUTION.mergeKLists(lists)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(convertToNodes(new int[][] {{1,4,5},{1,3,4},{2,6}}), convertToNode(new int[] {1,1,2,3,4,4,5,6})),
            Arguments.of(convertToNodes(new int[][] {{1,1,1},{1,1,1},{1,2}}), convertToNode(new int[] {1,1,1,1,1,1,1,2})),
            Arguments.of(convertToNodes(new int[][] {}), convertToNode(new int[] {})),
            Arguments.of(convertToNodes(new int[][] {{}}), convertToNode(new int[] {}))
        );
    }

    private static IntListNode[] convertToNodes(int[][] values) {
        return Arrays
            .stream(values).map(MergeKSortedListsTest::convertToNode)
            .toList()
            .toArray(new IntListNode[] {});
    }

    private static IntListNode convertToNode(int[] values) {
        IntListNode root = new IntListNode();
        IntListNode current = root;
        for (int value : values) {
            var newNode = new IntListNode();
            newNode.val = value;
            current.next = newNode;
            current = newNode;
        }
        return root.next;
    }

    private boolean areEqual(IntListNode actual, IntListNode expected) {
        var iteratorForActual = actual;
        var iteratorForExpected = expected;
        while (iteratorForActual != null) {
            if (iteratorForExpected == null) {
                return false;
            }
            if (iteratorForActual.val != iteratorForExpected.val) {
                System.out.println("Expected " + iteratorForExpected + ", actual" + iteratorForActual.val);
                return false;
            }

            System.out.println("Values are equal. Expected: " + iteratorForExpected.val + ", actual: " + iteratorForActual.val);
            iteratorForActual = iteratorForActual.next;
            iteratorForExpected = iteratorForExpected.next;
        }
        return iteratorForExpected == null;
    }
}
