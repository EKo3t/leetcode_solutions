package shadow.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import shadow.leetcode.util.Node;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MaximumDepthOfNTreeTest {

    private static final MaximumDepthOfNTree SOLUTION = new MaximumDepthOfNTree();

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void shouldReturnCorrectAnswer(Node given, int expected) {
        Assertions.assertEquals(expected, SOLUTION.maxDepth(given));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(getNodeForTest1(), 3),
            Arguments.of(getNodeForTest2(), 5)
        );
    }

    private static Node getNodeForTest1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children = new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        return node1;
    }

    private static Node getNodeForTest2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        node1.children = new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node1.children.add(node5);
        node3.children = new ArrayList<>();
        node3.children.add(node6);
        node3.children.add(node7);
        node7.children = new ArrayList<>();
        node7.children.add(node11);
        node11.children = new ArrayList<>();
        node11.children.add(node14);
        node4.children = new ArrayList<>();
        node4.children.add(node8);
        node8.children = new ArrayList<>();
        node8.children.add(node12);
        node5.children = new ArrayList<>();
        node5.children.add(node9);
        node5.children.add(node10);
        node9.children = new ArrayList<>();
        node9.children.add(node13);
        return node1;
    }

}
