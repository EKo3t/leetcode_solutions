package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.IntListNode;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class ReverseLinkedListIITest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(IntListNode given, int left, int right, IntListNode expected) {
        var objectUnderTest = new ReverseLinkedListII();
        Assertions.assertTrue(ListNodes.areEqual(expected, objectUnderTest.reverseBetween(given, left, right)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(ListNodes.convert(new int[]{1, 2, 3, 4, 5}), 2, 4, ListNodes.convert(new int[]{1, 4, 3, 2, 5})),
            Arguments.of(ListNodes.convert(new int[]{1, 2}), 1, 2, ListNodes.convert(new int[]{2, 1})),
            Arguments.of(ListNodes.convert(new int[]{1}), 1, 1, ListNodes.convert(new int[]{1}))
        );
    }
}
