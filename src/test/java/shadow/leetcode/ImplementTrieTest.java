package shadow.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImplementTrieTest {

    @Test
    public void shouldReturnCorrectResults() {
        test1();
    }

    private void test1() {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));   // return True
        assertFalse(trie.search("app"));     // return False
        assertTrue(trie.startsWith("app"));
        assertFalse(trie.startsWith("appp")); // return True
        trie.insert("app");
        assertTrue(trie.search("app"));     // return True
    }
}
