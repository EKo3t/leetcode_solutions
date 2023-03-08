package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KokoEatingBananasTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int hours, int expected) {
        var objectUnderTest = new KokoEatingBananas();
        Assertions.assertEquals(expected, objectUnderTest.minEatingSpeed(nums, hours));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
            Arguments.of(new int[]{30, 11, 23, 4, 20}, 5, 30),
            Arguments.of(new int[]{30, 11, 23, 4, 20}, 6, 23)
        );
    }
}
