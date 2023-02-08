package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JumpGameIITest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int expected) {
        var objectUnderTest = new JumpGameII();
        Assertions.assertEquals(expected, objectUnderTest.jump(nums));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 1, 1, 4}, 2),
            Arguments.of(new int[]{2, 1}, 1),
            Arguments.of(new int[]{2, 3, 0, 1, 4}, 2)
        );
    }
}
