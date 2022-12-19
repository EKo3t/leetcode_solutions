package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DailyTemperaturesTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int[] expected) {
        var objectUnderTest = new DailyTemperatures();
        Assertions.assertArrayEquals(expected, objectUnderTest.dailyTemperatures(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
            Arguments.of(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}, new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0}),
            Arguments.of(new int[]{30, 60, 90}, new int[]{1, 1, 0}),
            Arguments.of(new int[]{90, 60, 30}, new int[]{0, 0, 0}),
            Arguments.of(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0})
        );
    }
}
