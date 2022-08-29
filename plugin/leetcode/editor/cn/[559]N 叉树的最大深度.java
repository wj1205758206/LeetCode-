
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;

        int subMaxDepth = 0;

        for (Node child : root.children) {
            subMaxDepth = Math.max(subMaxDepth, maxDepth(child));
        }

        return subMaxDepth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
