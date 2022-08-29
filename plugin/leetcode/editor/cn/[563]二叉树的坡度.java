
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
    int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return tilt;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
