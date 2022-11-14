package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RunningSumOf1dArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int[] expected) {
        var objectUnderTest = new RunningSumOf1dArray();
        Assertions.assertArrayEquals(expected, objectUnderTest.runningSum(array));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3,4}, new int[] {1,3,6,10}),
            Arguments.of(new int[] {1,1,1,1,1}, new int[] {1,2,3,4,5}),
            Arguments.of(new int[] {3,1,2,10,1}, new int[] {3,4,6,16,17})
        );
    }
}
