package shadow.leetcode.plus_one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PlusOneTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int[] expected) {
        var objectUnderTest = new PlusOne();
        Assertions.assertArrayEquals(expected, objectUnderTest.plusOne(array));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3}, new int[] {1,2,4}),
            Arguments.of(new int[] {4,3,2,1}, new int[] {4,3,2,2}),
            Arguments.of(new int[] {8,9,9,9}, new int[] {9,0,0,0}),
            Arguments.of(new int[] {9}, new int[] {1,0})
        );
    }

}
