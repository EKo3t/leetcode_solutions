package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.RemoveDuplicatesFromSortedArray;

import java.util.stream.Stream;

public class RemoveDuplicatesFromSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int answer) {
        var objectUnderTest = new RemoveDuplicatesFromSortedArray();
        Assertions.assertEquals(answer, objectUnderTest.removeDuplicates(array));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,4}, 3),
            Arguments.of(new int[] {1, 2, 4, 4, 4, 5, 5, 6}, 5),
            Arguments.of(new int[] {0,0,1,1,1,2,2,3,3,4}, 5)
        );
    }
}
