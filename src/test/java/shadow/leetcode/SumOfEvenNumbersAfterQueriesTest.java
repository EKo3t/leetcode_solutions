package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SumOfEvenNumbersAfterQueriesTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int[][] queries, int[] expected) {
        var objectUnderTest = new SumOfEvenNumbersAfterQueries();
        Assertions.assertArrayEquals(expected, objectUnderTest.sumEvenAfterQueries(nums, queries));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3,4}, new int[][] {{1,0},{-3,1},{-4,0},{2,3}}, new int[] {8,6,2,4}),
            Arguments.of(new int[] {1}, new int[][] {{4,0}}, new int[] {0})
        );
    }
}
