package shadow.leetcode.remove_linked_list_elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RemoveLInkedListElementsTest {

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectResults(int[] givenArray, int valueToRemove, int[] expectedAnswer) {
        var objectUnderTest = new RemoveLinkedListElements();
        Assertions.assertTrue(areEqual(
            convert(expectedAnswer),
            objectUnderTest.removeElements(convert(givenArray), valueToRemove)
        ));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(new int[] {1,2,6,3,4,5,6}, 6, new int[] {1,2,3,4,5}),
            Arguments.of(new int[] {}, 1, new int[] {}),
            Arguments.of(new int[] {7,7,7,7}, 7, new int[] {})
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
