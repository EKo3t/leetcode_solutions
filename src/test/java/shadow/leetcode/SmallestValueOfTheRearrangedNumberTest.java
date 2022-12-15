package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SmallestValueOfTheRearrangedNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(long number, long expected) {
        var objectUnderTest = new SmallestValueOfTheRearrangedNumber();
        Assertions.assertEquals(expected, objectUnderTest.smallestNumber(number));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(639512, 123569),
            Arguments.of(63951112, 11123569),
            Arguments.of(100, 100),
            Arguments.of(3100, 1003),
            Arguments.of(0, 0),
            Arguments.of(96532111000L, 10001123569L),
            Arguments.of(-100011234569L, -965432111000L),
            Arguments.of(-7605, -7650),
            Arguments.of(310, 103),
            Arguments.of(63954120, 10234569)
        );
    }
}
