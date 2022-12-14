package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class HouseRobberTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int answer) {
        var objectUnderTest = new HouseRobber();
        Assertions.assertEquals(answer, objectUnderTest.rob(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 1}, 4),
            Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }
}
