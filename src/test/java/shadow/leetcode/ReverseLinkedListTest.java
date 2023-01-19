package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class ReverseLinkedListTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode node1, IntListNode node2) {
        var objectUnderTest = new ReverseLinkedList();
        Assertions.assertTrue(ListNodes.areEqual(node1, objectUnderTest.reverseList(node2)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(ListNodes.convert(new int[]{1, 2, 3, 4, 5}), ListNodes.convert(new int[]{5, 4, 3, 2, 1})),
            Arguments.of(ListNodes.convert(new int[]{1, 2}), ListNodes.convert(new int[]{2, 1})),
            Arguments.of(ListNodes.convert(new int[]{}), ListNodes.convert(new int[]{}))
        );
    }
}
