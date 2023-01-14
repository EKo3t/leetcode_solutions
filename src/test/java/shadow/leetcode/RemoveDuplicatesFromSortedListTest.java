package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class RemoveDuplicatesFromSortedListTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode node, IntListNode expected) {
        var objectUnderTest = new RemoveDuplicatesFromSortedList();
        Assertions.assertTrue(ListNodes.areEqual(expected, objectUnderTest.deleteDuplicates(node)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(ListNodes.convert(new int[]{1, 1, 2, 3, 3}), ListNodes.convert(new int[]{1, 2, 3}))
        );
    }
}
