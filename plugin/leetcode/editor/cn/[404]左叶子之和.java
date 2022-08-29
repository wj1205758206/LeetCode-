
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
    int leftSum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return leftSum;
        dfs(root);
        return leftSum;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left != null
                && root.left.left == null && root.left.right == null) {
            leftSum += root.left.val;
        }


        dfs(root.left);
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
