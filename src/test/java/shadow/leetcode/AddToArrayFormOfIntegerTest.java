package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AddToArrayFormOfIntegerTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] arr1, int k, int[] expected) {
        var objectUnderTest = new AddToArrayFormOfInteger();
        Assertions.assertArrayEquals(
            expected,
            objectUnderTest.addToArrayForm(arr1, k)
                .stream()
                .mapToInt(value -> value).toArray()
        );
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 0, 0}, 34, new int[]{1, 2, 3, 4})
        );
    }
}
