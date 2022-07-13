package shadow.leetcode.merge_two_sorted_lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MergeTwoSortedListsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] array1, int[] array2, int[] answer) {
        var objectUnderTest = new MergeTwoSortedLists();
        Assertions.assertTrue(areEqual(
            convert(answer),
            objectUnderTest.mergeTwoLists(convert(array1), convert(array2))
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {}, new int[] {}, new int[] {}),
            Arguments.of(new int[] {}, new int[] {0}, new int[] {0}),
            Arguments.of(new int[] {1,2,4}, new int[] {1,3,4}, new int[] {1, 1, 2, 3, 4, 4})
        );
    }

    private static ListNode convert(int[] array) {
        ListNode root = new ListNode();
        ListNode currentNode = root;
        for (int i : array) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return root.next;
    }

    private static boolean areEqual(ListNode node1, ListNode node2) {
        ListNode iterator1 = node1;
        ListNode iterator2 = node2;
        while (iterator1 != null) {
            if (iterator2 == null || iterator2.val != iterator1.val) {
                return false;
            }
            iterator2 = iterator2.next;
            iterator1 = iterator1.next;
        }
        return iterator2 == null;
    }
}
