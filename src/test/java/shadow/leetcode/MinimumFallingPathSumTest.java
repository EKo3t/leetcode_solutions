package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumFallingPathSumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[][] matrix, int sum) {
        var objectUnderTest = new MinimumFallingPathSum();
        Assertions.assertEquals(sum, objectUnderTest.minFallingPathSum(matrix));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[][] {{2,1,3},{6,5,4},{7,8,9}}, 13),
            Arguments.of(new int[][] {{-19,57},{-40,-5}}, -59),
            Arguments.of(new int[][] {{17, 82},{1, -44}}, -27)
        );
    }
}
