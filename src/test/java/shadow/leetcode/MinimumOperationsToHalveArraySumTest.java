package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumOperationsToHalveArraySumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int expected) {
        var objectUnderTest = new MinimumOperationsToHalveArraySum();
        Assertions.assertEquals(expected, objectUnderTest.halveArray(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {5, 19, 8, 1}, 3),
            Arguments.of(new int[] {3, 8, 20}, 3),
            Arguments.of(new int[] {1}, 1)
        );
    }
}
