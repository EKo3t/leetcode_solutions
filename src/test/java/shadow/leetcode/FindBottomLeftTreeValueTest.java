package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.TreeNodes;

import java.util.stream.Stream;

public class FindBottomLeftTreeValueTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(Integer[] given, int answer) {
        var objectUnderTest = new FindBottomLeftTreeValue();
        Assertions.assertEquals(answer, objectUnderTest.findBottomLeftValue(TreeNodes.convertToNode(given)));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
//            Arguments.of(new Integer[]{2, 1, 3}, 1),
            Arguments.of(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, null, null, 7}, 7)
        );
    }
}
