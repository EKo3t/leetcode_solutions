package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SelfDividingNumbersTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int left, int right, int[] expected) {
        var objectUnderTest = new SelfDividingNumbers();
        int[] result = objectUnderTest.selfDividingNumbers(left, right).stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(expected, result);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(1, 22, new int[] {1,2,3,4,5,6,7,8,9,11,12,15,22}),
            Arguments.of(47, 85, new int[] {48, 55, 66, 77})
        );
    }
}
