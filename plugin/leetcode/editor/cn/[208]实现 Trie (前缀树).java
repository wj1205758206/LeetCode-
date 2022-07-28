
//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    public Trie() {

    }

    public void insert(String word) {

    }

    public boolean search(String word) {

    }

    public boolean startsWith(String prefix) {

    }

    class TrieMap<V> {
        private static final int R;
        private int size = 0;
        private TrieNode<V> root = null;

        private static class TrieNode<V> {
            V val = null;
            TrieNode<V>[] children = new TrieNode[R];
        }

        public void put(String key, V val) {
            if (!containsKey(key)) {
                size++;
            }
            root = put(root, key, val, 0);
        }

        // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
        public TrieNode<V> put(TrieNode<V> node, String key, V val, int i) {
            if (node == null) {
                node = new TrieNode<>();
            }
            if (i == key.length()) {
                node.val = val;
                return node;
            }
            char c = key.charAt(i);
            node.children[c] = put(node.children[c], key, val, i + 1);
            return node;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
