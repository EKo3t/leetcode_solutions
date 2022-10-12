package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IncreasingTripletSubsequenceTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(int[] nums, boolean expected) {
        Assertions.assertEquals(expected, new IncreasingTripletSubsequence().increasingTriplet(nums));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
            Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
            Arguments.of(new int[]{2, 1, 5, 0, 4, 6}, true),
            Arguments.of(new int[]{1, 2, 2, 2, 2, 2}, false)
        );
    }
}
