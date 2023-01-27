package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class RemoveNthNodeFromEndOfListTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] givenArray, int valueToRemove, int[] expectedAnswer) {
        var objectUnderTest = new RemoveNthNodeFromEndOfList();
        Assertions.assertTrue(ListNodes.areEqual(
            ListNodes.convert(expectedAnswer),
            objectUnderTest.removeNthFromEnd(ListNodes.convert(givenArray), valueToRemove)
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 6, 3, 4, 5, 6}, 2, new int[]{1, 2, 6, 3, 4, 6}),
            Arguments.of(new int[]{1}, 1, new int[]{}),
            Arguments.of(new int[]{1, 2}, 1, new int[]{1})
        );
    }
}
