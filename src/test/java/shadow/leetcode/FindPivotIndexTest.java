package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FindPivotIndexTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int answer) {
        var objectUnderTest = new FindPivotIndex();
        Assertions.assertEquals(answer, objectUnderTest.pivotIndex(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1,7,3,6,5,6}, 3),
            Arguments.of(new int[]{1}, 0),
            Arguments.of(new int[]{1, 2, 3}, -1),
            Arguments.of(new int[]{2, 1, -1}, 0)
        );
    }}
