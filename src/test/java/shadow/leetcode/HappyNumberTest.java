package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HappyNumberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int given, boolean answer) {
        var objectUnderTest = new HappyNumber();
        Assertions.assertEquals(answer, objectUnderTest.isHappy(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(19, true),
            Arguments.of(2, false)
        );
    }
}
