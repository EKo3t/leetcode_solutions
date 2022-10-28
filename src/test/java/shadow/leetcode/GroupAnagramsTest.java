package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class GroupAnagramsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(String[] given, String[][] answer) {
        var objectUnderTest = new GroupAnagrams();
        List<List<String>> result = objectUnderTest.groupAnagrams(given);
        for (String[] strings : answer)
            Arrays.sort(strings);
        for (List<String> strings : result)
            Collections.sort(strings);
        Arrays.sort(answer, Comparator.comparing(o -> o[0]));
        result.sort(Comparator.comparing(o -> o.get(0)));

        if (answer.length != result.size()) {
            Assertions.fail("Expected " + answer.length + " groups. Got: " + result.size());
        }
        for (int i = 0; i < result.size(); i++) {
            List<String> currentGroup = result.get(i);
            if (answer[i].length != currentGroup.size()) {
                Assertions.fail("Expected " + answer.length + " items in group. Got: " + result.size());
            }
            for (int j = 0; j < currentGroup.size(); j++) {
                if (!answer[i][j].equals(currentGroup.get(j))) {
                    Assertions.fail("Expected " + answer[i][j] + ". Got: " + currentGroup.get(j));
                }
            }
        }
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new String[] {"eat","tea","tan","ate","nat","bat"}, new String[][] {
                {"bat"}, {"nat","tan"}, {"ate","eat","tea"}
            }),
            Arguments.of(new String[] {""}, new String[][] {{""}}),
            Arguments.of(new String[] {"a"}, new String[][] {{"a"}})
        );
    }
}
