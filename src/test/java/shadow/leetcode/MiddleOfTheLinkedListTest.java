package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class MiddleOfTheLinkedListTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int[] expected) {
        var objectUnderTest = new MiddleOfTheLinkedList();
        Assertions.assertTrue(ListNodes.areEqual(
            ListNodes.convert(expected),
            objectUnderTest.middleNode(ListNodes.convert(array))
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6}),
            Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}),
            Arguments.of(new int[]{1}, new int[]{1})
        );
    }
}
