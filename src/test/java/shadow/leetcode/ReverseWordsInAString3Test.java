package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ReverseWordsInAString3Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, String expected) {
        var objectUnderTest = new ReverseWordsInAString3();
        Assertions.assertEquals(expected, objectUnderTest.reverseWords(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
            Arguments.of("God Ding", "doG gniD")
        );
    }
}
