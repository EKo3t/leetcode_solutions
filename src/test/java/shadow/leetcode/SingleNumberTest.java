package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SingleNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int expected) {
        var objectUnderTest = new SingleNumber();
        Assertions.assertEquals(expected, objectUnderTest.singleNumber(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {2,2,1}, 1),
            Arguments.of(new int[] {4,1,2,1,2}, 4),
            Arguments.of(new int[] {-1,-1,-2,-3,-2}, -3),
            Arguments.of(new int[] {1}, 1)
        );
    }
}
