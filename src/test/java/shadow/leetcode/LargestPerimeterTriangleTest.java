package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LargestPerimeterTriangleTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int expected) {
        var objectUnderTest = new LargestPerimeterTriangle();
        Assertions.assertEquals(expected, objectUnderTest.largestPerimeter(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 1}, 0),
            Arguments.of(new int[] {2, 2, 1}, 5),
            Arguments.of(new int[] {32, 16, 8, 4, 2, 1}, 0),
            Arguments.of(new int[] {1, 1, 1}, 3),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 27)
        );
    }
}
