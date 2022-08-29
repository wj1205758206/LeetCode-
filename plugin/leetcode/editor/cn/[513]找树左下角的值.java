
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int maxDepth = 0;
    int depth = 0;
    TreeNode res = null;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root);
        return res.val;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        depth++;

        if (depth > maxDepth) {
            maxDepth = depth;
            res = root;
        }
        dfs(root.left);
        dfs(root.right);

        depth--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
