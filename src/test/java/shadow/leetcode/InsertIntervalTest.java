package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class InsertIntervalTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(int[][] intervals, int[] newInterval, int[][] expected) {
        Assertions.assertArrayEquals(expected, new InsertInterval().insert(intervals, newInterval));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[][]{{1, 3}, {6, 9}}, new int[] {2, 5}, new int[][]{{1, 5}, {6, 9}}),
            Arguments.of(new int[][]{{1, 5}}, new int[] {0, 3}, new int[][]{{0, 5}}),
            Arguments.of(new int[][]{}, new int[] {2, 5}, new int[][]{{2, 5}}),
            Arguments.of(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8}, new int[][]{{1, 2}, {3, 10}, {12, 16}})
        );
    }
}
