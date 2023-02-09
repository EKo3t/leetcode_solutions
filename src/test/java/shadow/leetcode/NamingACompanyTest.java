package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NamingACompanyTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] ideas, int expected) {
        var objectUnderTest = new NamingACompany();
        Assertions.assertEquals(expected, objectUnderTest.distinctNames(ideas));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[] {"coffee","donuts","time","toffee"}, 6),
            Arguments.of(new String[] {"coffee", "toffee"}, 0),
            Arguments.of(new String[] {"abc", "bbc", "cbc", "dbc", "ebc", "fbc", "gbc", "atyu", "btyu", "ctyu", "dtyu", "xtyu", "ytyu", "ztyu"}, 18)
        );
    }
}
