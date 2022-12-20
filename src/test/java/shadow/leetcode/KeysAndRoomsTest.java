package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeysAndRoomsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(List<List<Integer>> rooms, boolean expectedToVisitAllRooms) {
        var objectUnderTest = new KeysAndRooms();
        Assertions.assertEquals(expectedToVisitAllRooms, objectUnderTest.canVisitAllRooms(rooms));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(toListOfListsOfInts("1;2;3;"), true),
            Arguments.of(toListOfListsOfInts("1,3;3,0,1;2;0"), false)
        );
    }

    // inner delimiter is ',', outer is ';'. It is done to simplify entering tests and reduce spent time
    private static List<List<Integer>> toListOfListsOfInts(String text) {
        List<List<Integer>> rooms = new ArrayList<>();
        return Arrays
            .stream(text.split(";", -1))
            .map(s -> s.split(","))
            .map(keys -> {
                if (keys.length == 1 && keys[0].isEmpty()) {
                    return Collections.<Integer>emptyList();
                }
                return Arrays.stream(keys)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            })
            .collect(Collectors.toList());
    }
}
