package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class VerifyingAnAlienDictionaryTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] given, String order, boolean answer) {
        var objectUnderTest = new VerifyingAnAlienDictionary();
        Assertions.assertEquals(answer, objectUnderTest.isAlienSorted(given, order));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
            Arguments.of(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz", false),
            Arguments.of(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz", false)
        );
    }
}
