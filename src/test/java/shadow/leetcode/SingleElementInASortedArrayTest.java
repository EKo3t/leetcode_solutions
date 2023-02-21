package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SingleElementInASortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int expected) {
        var objectUnderTest = new SingleElementInASortedArray();
        Assertions.assertEquals(expected, objectUnderTest.singleNonDuplicate(nums));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}, 2),
            Arguments.of(new int[]{3, 3, 7, 7, 10, 11, 11}, 10),
            Arguments.of(new int[]{3, 3, 7, 7, 10, 10, 11, 11, 12}, 12),
            Arguments.of(new int[]{3, 3, 7, 7, 10, 10, 11, 12, 12}, 11),
            Arguments.of(new int[]{1, 3, 3, 7, 7, 10, 10, 11, 11, 12, 12}, 1),
            Arguments.of(new int[]{1, 1, 3, 7, 7, 10, 10, 11, 11, 12, 12}, 3)
        );
    }
}
