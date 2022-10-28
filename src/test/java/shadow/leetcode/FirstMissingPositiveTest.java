package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FirstMissingPositiveTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int firstPositive) {
        var objectUnderTest = new FirstMissingPositive();
        Assertions.assertEquals(firstPositive, objectUnderTest.firstMissingPositive(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,0}, 3),
            Arguments.of(new int[] {3,4,-1,1}, 2),
            Arguments.of(new int[] {7,8,9,11,12}, 1),
            Arguments.of(new int[] {10,9,8,7,6,5,4,3,2,1}, 11)
        );
    }
}
