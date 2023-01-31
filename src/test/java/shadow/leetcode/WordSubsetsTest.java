package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.MyCollections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WordSubsetsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] words1, String[] words2, List<String> expectedAnswer) {
        var objectUnderTest = new WordSubsets();
        Assertions.assertTrue(MyCollections.hasTheSameElements(expectedAnswer, objectUnderTest.wordSubsets(words1, words2)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e","o"},
                Arrays.asList("facebook","google","leetcode")),
            Arguments.of(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l","e"},
                Arrays.asList("apple","google","leetcode")),
            Arguments.of(new String[] {"warrior"}, new String[] {"wrr"},
                List.of("warrior"))
        );
    }
}
