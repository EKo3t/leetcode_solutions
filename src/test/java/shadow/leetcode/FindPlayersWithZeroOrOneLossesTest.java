package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class FindPlayersWithZeroOrOneLossesTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[][] matches, int[][] expected) {
        var objectUnderTest = new FindPlayersWithZeroOrOneLosses();
        List<List<Integer>> result = objectUnderTest.findWinners(matches);
        Assertions.assertArrayEquals(expected[0], result.get(0).stream().mapToInt(Integer::intValue).toArray());
        Assertions.assertArrayEquals(expected[1], result.get(1).stream().mapToInt(Integer::intValue).toArray());
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(
                new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}},
                new int[][]{{1, 2, 5, 6}, {}}
            ),
            Arguments.of(
                new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}},
                new int[][]{{1, 2, 10}, {4, 5, 7, 8}}
            )
        );
    }
}
