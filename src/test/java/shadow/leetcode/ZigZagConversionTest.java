package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ZigZagConversionTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String given, int numberOfRows, String expected) {
        var objectUnderTest = new ZigZagConversion();
        Assertions.assertEquals(expected, objectUnderTest.convert(given, numberOfRows));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                1, "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."),
            Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
            Arguments.of("A", 1, "A")
        );
    }

}
