package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindOriginalArrayFromDoubledTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int[] answer) {
        var objectUnderTest = new FindOriginalArrayFromDoubled();
        Assertions.assertArrayEquals(answer, objectUnderTest.findOriginalArray(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 3, 4, 2, 6, 8}, new int[]{1, 3, 4}),
            Arguments.of(new int[]{1, 3, 4, 3, 3, 3, 3, 2, 6, 6, 6, 6, 6, 8}, new int[]{1, 3, 3, 3, 3, 3, 4}),
            Arguments.of(new int[]{0, 0, 1, 3, 4, 3, 3, 3, 3, 2, 6, 6, 6, 6, 6, 8}, new int[]{0, 1, 3, 3, 3, 3, 3, 4}),
            Arguments.of(new int[]{0, 1, 3, 4, 3, 3, 3, 3, 2, 6, 6, 6, 6, 6, 8}, new int[]{}),
            Arguments.of(new int[]{6, 3, 0, 1}, new int[]{}),
            Arguments.of(new int[]{1}, new int[]{})
        );
    }
}
