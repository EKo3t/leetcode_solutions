package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ClimbingStairsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int given, int answer) {
        var objectUnderTest = new ClimbingStairs();
        Assertions.assertEquals(answer, objectUnderTest.climbStairs(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(2, 2),
            Arguments.of(3, 3),
            Arguments.of(4, 5),
            Arguments.of(45, 1836311903)
        );
    }
}
