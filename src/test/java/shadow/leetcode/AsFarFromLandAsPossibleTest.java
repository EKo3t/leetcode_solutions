package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AsFarFromLandAsPossibleTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[][] given, int expected) {
        var objectUnderTest = new AsFarFromLandAsPossible();
        Assertions.assertEquals(expected, objectUnderTest.maxDistance(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}, 2),
            Arguments.of(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}, 4),
            Arguments.of(new int[][]{{0, 0, 1, 1, 1}, {0, 1, 1, 0, 0}, {0, 0, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 1}}, 2),
            Arguments.of(new int[][]{{1}}, -1),
            Arguments.of(new int[][]{{0}}, -1)
        );
    }
}
