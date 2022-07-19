package shadow.leetcode.implement_strstr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ImplementStrStrTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String string, String subString, int answer) {
        var objectUnderTest = new ImplementStrStr_Naive();
        Assertions.assertEquals(answer, objectUnderTest.strStr(string, subString));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("hello", "ll", 2),
            Arguments.of("aaaaa", "bba", -1),
            Arguments.of("mississippi", "mississippi", 0),
            Arguments.of("mississippi", "mississippiqqqq", -1),
            Arguments.of("mississippiqqq", "mississippi", 0),
            Arguments.of("qmissiqmississippiqqq", "mississippi", 7)
        );
    }
}
