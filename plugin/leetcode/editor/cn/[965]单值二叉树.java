
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
    int preval;
    boolean isUnival = true;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        preval = root.val;

        dfs(root);

        return isUnival;
    }

    public void dfs(TreeNode root) {
        if (root == null || !isUnival) {
            return;
        }

        if (root.val != preval) {
            isUnival = false;
            return;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
