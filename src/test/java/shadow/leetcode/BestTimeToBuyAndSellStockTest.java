package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BestTimeToBuyAndSellStockTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, int maxDiff) {
        var objectUnderTest = new BestTimeToBuyAndSellStock();
        Assertions.assertEquals(maxDiff, objectUnderTest.maxProfit(numbers));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {7,1,5,3,6,4}, 5),
            Arguments.of(new int[] {7,6,4,3,1}, 0)
        );
    }
}
