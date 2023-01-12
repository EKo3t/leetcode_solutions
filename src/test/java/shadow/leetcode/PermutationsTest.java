package shadow.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PermutationsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int[][] expected) {
        var objectUnderTest = new Permutations();
        List<List<Integer>> result = objectUnderTest.permute(array);
        System.out.println(result);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}}),
            Arguments.of(new int[]{0, 1}, new int[][]{{0, 1}, {1, 0}}),
            Arguments.of(new int[]{1}, new int[][]{{1}, {1}})
        );
    }
}
