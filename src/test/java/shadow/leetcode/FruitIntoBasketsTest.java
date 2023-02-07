package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FruitIntoBasketsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int expected) {
        var objectUnderTest = new FruitIntoBaskets();
        Assertions.assertEquals(expected, objectUnderTest.totalFruit(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 1}, 3),
            Arguments.of(new int[]{1, 2, 3, 2, 2}, 4),
            Arguments.of(new int[]{2, 1, 0, 1, 1, 1, 2}, 5),
            Arguments.of(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, 5),
            Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1}, 7),
            Arguments.of(new int[]{0, 1, 2, 2}, 3)
        );
    }
}
