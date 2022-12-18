package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RearrangeArrayElementsBySignTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int[] expected) {
        var objectUnderTest = new RearrangeArrayElementsBySign();
        Assertions.assertArrayEquals(expected, objectUnderTest.rearrangeArray(nums));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{3, 1, -2, -5, 2, -4}, new int[]{3, -2, 1, -5, 2, -4}),
            Arguments.of(new int[]{-1, 1}, new int[]{1, -1})
        );
    }
}
