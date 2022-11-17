package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RectangleAreaTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2, int expected) {
        var objectUnderTest = new RectangleArea();
        Assertions.assertEquals(expected, objectUnderTest.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(-3, 0, 3, 4, 0, -1, 9, 2, 45),
            Arguments.of(0, 0, 0, 0, -1, -1, 1, 1, 4),
            Arguments.of(-2, -2, 2, 2, -2, -2, 2, 2, 16)
        );
    }
}
