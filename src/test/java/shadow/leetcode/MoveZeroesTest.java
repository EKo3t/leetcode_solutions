package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MoveZeroesTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array1, int[] array2) {
        var objectUnderTest = new MoveZeroes();
        objectUnderTest.moveZeroes(array1);
        Assertions.assertArrayEquals(array2, array1);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 0, 0, 0}, new int[]{1, 2, 3, 0, 0, 0}),
            Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
            Arguments.of(new int[]{1, 0, 0, 2, 0, 3}, new int[]{1, 2, 3, 0, 0, 0})
        );
    }
}
