package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.MyCollections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PascalsTriangleTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int number, int[][] expected) {
        var objectUnderTest = new PascalsTriangle();
        List<List<Integer>> result = objectUnderTest.generate(number);
        List<List<Integer>> boxedExpected = Arrays
            .stream(expected)
            .map(ints ->
                Arrays.stream(ints).boxed().collect(Collectors.toList())
            ).toList();

        if (result.size() != boxedExpected.size())
            Assertions.fail("sizes different");

        for (int i = 0; i < result.size(); i++) {
            if (!MyCollections.areEqual(boxedExpected.get(i), result.get(i), Integer::compareTo))
                Assertions.fail("lists are different");
        }
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
//            Arguments.of(5, new int[][]{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}}),
            Arguments.of(31, new int[][]{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}})
        );
    }
}
