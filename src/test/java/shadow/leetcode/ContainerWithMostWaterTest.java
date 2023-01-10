package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ContainerWithMostWaterTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] given, int answer) {
        var objectUnderTest = new ContainerWithMostWater();
        Assertions.assertEquals(answer, objectUnderTest.maxArea(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,8,6,2,5,4,8,3,7}, 49),
            Arguments.of(new int[] {1, 1}, 1)
        );
    }
}
