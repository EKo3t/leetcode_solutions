package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KthMissingPositiveNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int k, int expected) {
        var objectUnderTest = new KthMissingPositiveNumber();
        Assertions.assertEquals(expected, objectUnderTest.findKthPositive(nums, k));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {2,3,4,7,11}, 5, 9),
            Arguments.of(new int[] {1,2,3,4}, 2, 6)
        );
    }
}
