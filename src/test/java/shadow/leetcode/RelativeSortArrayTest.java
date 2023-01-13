package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RelativeSortArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array1, int[] array2, int[] expected) {
        var objectUnderTest = new RelativeSortArray();
        Assertions.assertArrayEquals(expected, objectUnderTest.relativeSortArray(array1, array2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}, new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}),
            Arguments.of(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}, new int[]{22, 28, 8, 6, 17, 44})
        );
    }
}
