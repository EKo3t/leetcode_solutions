package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _3SumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, List<List<Integer>> expected) {
        var objectUnderTest = new _3Sum();
        List<List<Integer>> result = objectUnderTest.threeSum(array)
            .stream()
            .sorted(Comparator.comparingInt((List<Integer> o) -> o.get(0)).thenComparingInt(o -> o.get(1)).thenComparingInt(o -> o.get(2)))
            .collect(Collectors.toList());
        for (int i = 0; i < result.size(); i++) {
            assertElement(expected, result, i, 0);
            assertElement(expected, result, i, 1);
            assertElement(expected, result, i, 2);
        }
    }

    private void assertElement(List<List<Integer>> expected, List<List<Integer>> result, int i, int index) {
        int expectedElement = expected.get(i).get(index);
        int resultElement = result.get(i).get(index);
        if (expectedElement != resultElement) Assertions.fail(expectedElement + "!=" + resultElement);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{-2, 0, 0, 2, 2}, List.of(List.of(-2, 0, 2))),
            Arguments.of(new int[]{-1, 0, 1, 2, -1, -4}, List.of(
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
            )),
            Arguments.of(new int[]{-1, 0, 1, 2, 2, 2, -1, -4, -4}, List.of(
                List.of(-4, 2, 2),
                List.of(-1, -1, 2),
                List.of(-1, 0, 1)
            )),
            Arguments.of(new int[]{0, 0, 0}, List.of(List.of(0, 0, 0))),
            Arguments.of(new int[]{0, 1, 1}, List.of())
        );
    }
}
