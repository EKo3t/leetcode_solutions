package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KthLargestElementInAnArrayTest {


    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int kThLargest, int expected) {
        var objectUnderTest = new KthLargestElementInAnArray();
        Assertions.assertEquals(expected, objectUnderTest.findKthLargest(nums, kThLargest));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {3,2,1,5,6,4}, 2, 5),
            Arguments.of(new int[] {3,2,3,1,2,4,5,5,6}, 4, 4),
            Arguments.of(new int[] {3,2,3,1,2,4,5,5,6}, 9, 1),
            Arguments.of(new int[] {3,2,3,1,2,4,5,5,6,-10000}, 10, -10000),
            Arguments.of(new int[] {0}, 1, 0)
        );
    }
}
