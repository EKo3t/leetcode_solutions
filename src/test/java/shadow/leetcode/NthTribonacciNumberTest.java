package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NthTribonacciNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int n, int expectedNumber) {
        var objectUnderTest = new NthTribonacciNumber();
        Assertions.assertEquals(expectedNumber, objectUnderTest.tribonacci(n));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(4, 4),
            Arguments.of(25, 1389537),
            Arguments.of(37, 2082876103)
        );
    }
}
