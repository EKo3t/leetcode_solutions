package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.ListNodes;

import java.util.stream.Stream;

public class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array1, int[] array2, int[] answer) {
        var objectUnderTest = new MergeTwoSortedLists();
        Assertions.assertTrue(ListNodes.areEqual(
            ListNodes.convert(answer),
            objectUnderTest.mergeTwoLists(ListNodes.convert(array1), ListNodes.convert(array2))
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {}, new int[] {}, new int[] {}),
            Arguments.of(new int[] {}, new int[] {0}, new int[] {0}),
            Arguments.of(new int[] {1,2,4}, new int[] {1,3,4}, new int[] {1, 1, 2, 3, 4, 4})
        );
    }
}
