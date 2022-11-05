package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ShuffleStringTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String s, int[] shuffles, String expected) {
        var objectUnderTest = new ShuffleString();
        Assertions.assertEquals(expected, objectUnderTest.restoreString(s, shuffles));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("codeleet", new int[] {4,5,6,7,0,2,1,3}, "leetcode"),
            Arguments.of("abc", new int[] {0,1,2}, "abc")
        );
    }
}
