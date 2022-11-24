package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WordSearchTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(char[][] given, String word, boolean answer) {
        var objectUnderTest = new WordSearch();
        Assertions.assertEquals(answer, objectUnderTest.exist(given, word));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(
                new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE" , true
            ),
            Arguments.of(
                new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB" , false
            ),
            Arguments.of(
                new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED" , true
            ),
            Arguments.of(
                new char[][] {{'a','b'}}, "ba" , true
            )
        );
    }
}
