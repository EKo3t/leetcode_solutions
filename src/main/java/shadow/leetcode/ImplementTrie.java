package shadow.leetcode;

import java.util.TreeSet;

import static java.util.Optional.ofNullable;

/**
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree">Task description</a>
 * Difficulty: medium
 */
public class ImplementTrie {

    private final TreeSet<String> values;

    public ImplementTrie() {
        values = new TreeSet<>();
    }

    public void insert(String word) {
        values.add(word);
    }

    public boolean search(String word) {
        return values.contains(word);
    }

    public boolean startsWith(String prefix) {
        var floorContainsPrefix = ofNullable(values.floor(prefix)).filter(str -> str.startsWith(prefix));
        var ceilingContainsPrefix = ofNullable(values.ceiling(prefix)).filter(str -> str.startsWith(prefix));
        return floorContainsPrefix.isPresent() || ceilingContainsPrefix.isPresent();
    }
}
