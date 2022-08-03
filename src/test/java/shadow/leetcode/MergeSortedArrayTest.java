package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array1, int[] array2) {
        var objectUnderTest = new MergeSortedArray();
        var mergedArray = new int[array1.length];
        System.arraycopy(array1, 0, mergedArray, 0, array1.length);
        System.arraycopy(array2, 0, mergedArray, array1.length - array2.length, array2.length);
        Arrays.sort(mergedArray);
        objectUnderTest.merge(array1, array1.length - array2.length, array2, array2.length);
        Assertions.assertArrayEquals(mergedArray, array1);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3,0,0,0}, new int[] {2,5,6}),
            Arguments.of(new int[] {1}, new int[] {}),
            Arguments.of(new int[] {0}, new int[] {1}),
            Arguments.of(new int[] {2,0}, new int[] {1})
        );
    }
}
