package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class IsomorphicStringsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String str1, String str2, boolean expected) {
        var objectUnderTest = new IsomorphicStrings();
        Assertions.assertEquals(expected, objectUnderTest.isIsomorphic(str1, str2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("foo", "bar", false),
            Arguments.of("paper", "title", true),
            Arguments.of("badc", "baba", false),
            Arguments.of("egg", "add", true)
        );
    }
}
