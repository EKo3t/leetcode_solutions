package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidPalindromeTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, boolean answer) {
        var objectUnderTest = new ValidPalindrome();
        Assertions.assertEquals(answer, objectUnderTest.isPalindrome(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of("0P", false)
        );
    }
}
