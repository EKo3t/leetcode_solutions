package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CheckIfTwoStringArraysAreEquivalentTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] strArray1, String[] strArray2, boolean expected) {
        var objectUnderTest = new CheckIfTwoStringArraysAreEquivalent();
        Assertions.assertEquals(expected, objectUnderTest.arrayStringsAreEqual(strArray1, strArray2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[] {"ab", "c"}, new String[] {"a", "bc"}, true),
            Arguments.of(new String[] {"ac", "b"}, new String[] {"ab", "c"}, false),
            Arguments.of(new String[] {"abc", "d", "defg"}, new String[] {"abcddefg"}, true)
        );
    }
}
