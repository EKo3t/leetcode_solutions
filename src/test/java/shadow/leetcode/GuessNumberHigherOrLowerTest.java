package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GuessNumberHigherOrLowerTest {


    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int range, int target) {
        var objectUnderTest = new GuessNumberHigherOrLower(target);
        Assertions.assertEquals(target, objectUnderTest.guessNumber(range));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
//            Arguments.of(1, 1),
//            Arguments.of(2, 1),
//            Arguments.of(1_000_000_000, 734894243),
            Arguments.of(2126753390, 1702766719)
//            Arguments.of(10, 6)
        );
    }
}
