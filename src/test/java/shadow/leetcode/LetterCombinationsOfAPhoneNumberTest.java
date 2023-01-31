package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.MyCollections;

import java.util.stream.Stream;

public class LetterCombinationsOfAPhoneNumberTest {

    private static final LetterCombinationsOfAPhoneNumber SOLUTION = new LetterCombinationsOfAPhoneNumber();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(String given, String[] expected) {
        Assertions.assertTrue(MyCollections.areEqual(expected, SOLUTION.letterCombinations(given)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
//            Arguments.of("23", new String[] {"ad","ae","af","bd","be","bf","cd","ce","cf"}),
            Arguments.of("234", new String[] {"ad","ae","af","bd","be","bf","cd","ce","cf"})
        );
    }
}
