package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.RemoveElement;

import java.util.stream.Stream;

public class RemoveElementTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array, int numberToDelete, int answer) {
        var objectUnderTest = new RemoveElement();
        Assertions.assertEquals(answer, objectUnderTest.removeElement(array, numberToDelete));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {3,2,2,3}, 3, 2),
            Arguments.of(new int[] {0,1,2,2,3,0,4,2}, 2, 5),
            Arguments.of(new int[] {0,1,2,2,3,0,4,2}, 90, 8),
            Arguments.of(new int[] {}, 2, 0)
        );
    }
}
