package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaximumSubarrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int maxSum) {
        var objectUnderTest = new MaximumSubarray();
        Assertions.assertEquals(maxSum, objectUnderTest.maxSubArray(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{5, 4, -1, 7, 8}, 23)
        );
    }
}
