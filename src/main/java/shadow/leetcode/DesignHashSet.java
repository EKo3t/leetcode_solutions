package shadow.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/design-hashset/">Task description</a>
 * Difficulty: easy
 */
public class DesignHashSet {

    private static final int SIZE = 20000;
    private static final int MULTIPLIER = 31;
    private final Node[] values;

    public DesignHashSet() {
        values = new Node[SIZE];
    }

    public void add(int key) {
        int hash = hash(key);
        if (values[hash] == null)
            values[hash] = new Node();
        values[hash].add(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        if (values[hash] != null)
            values[hash].remove(key);
    }

    public boolean contains(int key) {
        int hash = hash(key);
        if (values[hash] != null)
            return values[hash].contains(key);
        else return false;
    }

    private int hash(int key) {
        int hash = 0;
        while (key > 0) {
            hash = (hash + key % 10 * MULTIPLIER) % SIZE;
            key /= 10;
        }
        return hash;
    }

    private static class Node {
        private final List<Integer> objects;

        public Node() {
            objects = new ArrayList<>();
        }

        public void add(int value) {
            if (!contains(value))
                objects.add(value);
        }

        public void remove(int value) {
            for (Integer object : objects) {
                if (object == value) {
                    objects.remove(object);
                    break;
                }
            }
        }

        public boolean contains(int value) {
            for (int object : objects)
                if (object == value) return true;

            return false;
        }
    }
}
