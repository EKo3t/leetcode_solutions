package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RotateArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int k, int[] expected) {
        var objectUnderTest = new RotateArray();
        objectUnderTest.rotate(given, k);
        Assertions.assertArrayEquals(expected, given);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3,4,5,6,7}, 3, new int[] {5,6,7,1,2,3,4}),
            Arguments.of(new int[] {-1,-100,3,99}, 2, new int[] {3,99,-1,-100}),
            Arguments.of(new int[] {-1}, 0, new int[] {-1}),
            Arguments.of(new int[] {-1}, 10000, new int[] {-1}),
            Arguments.of(new int[] {-1, -2}, 1, new int[] {-2, -1}),
            Arguments.of(new int[] {-1, -2}, 2, new int[] {-1, -2}),
            Arguments.of(new int[] {-1, -2}, 3, new int[] {-2, -1}),
            Arguments.of(new int[] {-1, -2}, 99999, new int[] {-2, -1})
        );
    }
}
