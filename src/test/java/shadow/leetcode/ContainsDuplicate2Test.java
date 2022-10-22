package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ContainsDuplicate2Test {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] nums, int k, boolean answer) {
        var objectUnderTest = new ContainsDuplicate2();
        Assertions.assertEquals(answer, objectUnderTest.containsNearbyDuplicate(nums, k));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,3,1}, 3, true),
            Arguments.of(new int[] {1,0,1,1}, 1, true),
            Arguments.of(new int[] {1,2,3,1,2,3}, 2, false),
            Arguments.of(new int[] {1,0,1,0,1,0}, 1, false)
        );
    }
}
