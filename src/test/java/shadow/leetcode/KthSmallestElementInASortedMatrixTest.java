package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class KthSmallestElementInASortedMatrixTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[][] matrix, int k, int expected) {
        var objectUnderTest = new KthSmallestElementInASortedMatrix();
        Assertions.assertEquals(expected, objectUnderTest.kthSmallest(matrix, k));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 8, 13),
            Arguments.of(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 9, 15),
            Arguments.of(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 7, 13),
            Arguments.of(new int[][] {{1,5,9},{10,11,13},{12,13,15}}, 1, 1),
            Arguments.of(new int[][] {{-5}}, 1, -5)
        );
    }
}
