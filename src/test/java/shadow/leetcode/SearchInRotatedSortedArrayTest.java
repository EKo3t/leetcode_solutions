package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchInRotatedSortedArrayTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int target, int expected) {
        var objectUnderTest = new SearchInRotatedSortedArray();
        Assertions.assertEquals(expected, objectUnderTest.search(nums, target));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
            Arguments.of(new int[]{9, 12, 15, 18, 21, 0, 1, 2, 3}, 0, 5),
            Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 0),
            Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 9, 9),
            Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 5, 5),
            Arguments.of(new int[]{10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 0, 1),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
            Arguments.of(new int[]{1}, 0, -1)

            );
    }
}
