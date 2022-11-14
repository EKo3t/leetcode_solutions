package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BinarySearchTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int target, int expectedIndex) {
        var objectUnderTest = new BinarySearch();
        Assertions.assertEquals(expectedIndex, objectUnderTest.search(given, target));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {-1,0,3,5,9,12}, 2, -1),
            Arguments.of(new int[] {-1,0,3,5,9,12}, -2, -1),
            Arguments.of(new int[] {-1,0,3,5,9,12}, -1, 0),
            Arguments.of(new int[] {-1}, -1, 0),
            Arguments.of(new int[] {-1,0,3,5,9,12}, 13, -1),
            Arguments.of(new int[] {-1,0,3,5,9,12}, 9, 4),
            Arguments.of(new int[] {-1}, 9, -1)
        );
    }
}
