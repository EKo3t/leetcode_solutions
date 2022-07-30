package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchInsertPositionTest {
    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int numberToInsert, int answer) {
        var objectUnderTest = new SearchInsertPosition();
        Assertions.assertEquals(answer, objectUnderTest.searchInsert(array, numberToInsert));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,3,5,6}, 5, 2),
            Arguments.of(new int[] {1,3,5,6}, 2, 1),
            Arguments.of(new int[] {1,3,5,6}, 7, 4),
            Arguments.of(new int[] {1,3,5,5,5,5,5,5,6}, 5, 2),
            Arguments.of(new int[] {1,3,5,5,5,5,5,5,6}, 4, 2),
            Arguments.of(new int[] {1,3,5,5,5,5,5,5,6}, 6, 8)
        );
    }
}
