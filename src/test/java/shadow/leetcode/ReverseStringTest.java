package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseStringTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(char[] given, char[] answer) {
        var objectUnderTest = new ReverseString();
        objectUnderTest.reverseString(given);
        Assertions.assertArrayEquals(answer, given);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new char[] {'H','a','n','n','a','h'}, new char[] {'h','a','n','n','a','H'}),
            Arguments.of(new char[] {'h','e','l','l','o'}, new char[] {'o','l','l','e','h'})
        );
    }
}
