package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FirstBadVersionTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int versionCount, int firstBadVersion) {
        var objectUnderTest = new FirstBadVersion(firstBadVersion);
        Assertions.assertEquals(firstBadVersion, objectUnderTest.firstBadVersion(versionCount));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(5, 4),
            Arguments.of(1, 1),
            Arguments.of(2126753390, 1702766719)
        );
    }
}
