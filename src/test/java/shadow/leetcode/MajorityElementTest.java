package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MajorityElementTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int major) {
        var objectUnderTest = new MajorityElement();
        Assertions.assertEquals(major, objectUnderTest.majorityElement(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }
}
