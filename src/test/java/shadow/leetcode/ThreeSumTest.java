package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static shadow.leetcode.util.Collections.newArrayList;

public class ThreeSumTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] numbers, List<List<Integer>> expectedTriplets) {
        var objectUnderTest = new ThreeSum();
        List<List<Integer>> answer = objectUnderTest.threeSum(numbers);
        validateLengthAndSortTriplets(answer);
        validateLengthAndSortTriplets(expectedTriplets);
        checkDuplicates(answer);
        checkDuplicates(expectedTriplets);
        Assertions.assertTrue(areEqualTriplets(answer, expectedTriplets));
        Assertions.assertEquals(expectedTriplets, objectUnderTest.threeSum(numbers));
    }

    // doesn't check duplicates
    private boolean areEqualTriplets(List<List<Integer>> triplets1, List<List<Integer>> triplets2) {
        Set<List<Integer>> triplets = new HashSet<>();
        for (List<Integer> triplet : triplets1) {
            triplets.add(Collections.unmodifiableList(triplet));
        }
        for (List<Integer> triplet : triplets2) {
            if (!triplets.contains(triplet)) {
                return false;
            }
        }
        return true;
    }

    private void checkDuplicates(List<List<Integer>> triplets) {
        for (List<Integer> triplet : triplets) {
            boolean isAdded = triplets.add(Collections.unmodifiableList(triplet));
            if (!isAdded) {
                throw new RuntimeException("Found duplicate in triplets {" + triplet.get(0) + ", " + triplet.get(1) + ", " + triplet.get(2) + "}");
            }
        }
    }

    private void validateLengthAndSortTriplets(List<List<Integer>> triplets) {
        for (List<Integer> triplet : triplets) {
            if (triplet.size() != 3) {
                throw new RuntimeException("Triplet length must be 3");
            }
            triplet.sort(Integer::compareTo);
        }
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {-1,0,1,2,-1,-4}, newArrayList(
                newArrayList(-1, -1, 2),
                newArrayList(-1, 0, 1)
            )),
            Arguments.of(1, true),
            Arguments.of(9, true)
        );
    }
}
