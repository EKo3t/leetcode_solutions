package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.Collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MajorityElement2Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int[] expected) {
        var objectUnderTest = new MajorityElement2();
        List<Integer> expectedElements = Arrays.stream(expected).boxed().collect(Collectors.toList());
        Assertions.assertTrue(Collections.areEqual(expectedElements, objectUnderTest.majorityElement(numbers)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{3, 2, 3}, new int[]{3})
        );
    }
}
