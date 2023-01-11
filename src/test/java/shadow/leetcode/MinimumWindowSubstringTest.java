package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MinimumWindowSubstringTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String str1, String str2, String expected) {
        var objectUnderTest = new MinimumWindowSubstring();
        Assertions.assertEquals(expected, objectUnderTest.minWindow(str1, str2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
            Arguments.of("a", "a", "a"),
            Arguments.of("a", "aa", ""),
            Arguments.of("aaaaaaaaaaaabbbbbcdd", "abcdd", "abbbbbcdd")
        );
    }
}
