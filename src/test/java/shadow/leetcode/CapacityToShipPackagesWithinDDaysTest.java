package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CapacityToShipPackagesWithinDDaysTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] weights, int days, int expectedCapacity) {
        var objectUnderTest = new CapacityToShipPackagesWithinDDays();
        Assertions.assertEquals(expectedCapacity, objectUnderTest.shipWithinDays(weights, days));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 15),
            Arguments.of(new int[]{3, 2, 2, 4, 1, 4}, 3, 6),
            Arguments.of(new int[]{1, 2, 3, 1, 1}, 4, 3)
        );
    }
}
