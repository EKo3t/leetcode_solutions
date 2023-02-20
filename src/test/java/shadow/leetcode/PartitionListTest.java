package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class PartitionListTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode head, int target, IntListNode expected) {
        var objectUnderTest = new PartitionList();
        Assertions.assertTrue(ListNodes.areEqual(expected, objectUnderTest.partition(head, target)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(ListNodes.convert(new int[] {1,4,3,2,5,2}), 3, ListNodes.convert(new int[] {1,2,2,4,3,5}))
        );
    }
}
