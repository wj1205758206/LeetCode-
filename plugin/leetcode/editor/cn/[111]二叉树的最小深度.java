
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftMin = minDepth(root.left);
        int rightMin = minDepth(root.right);

        //无子树的情况
        if (root.left == null || root.right == null) {
            return leftMin + rightMin + 1;
        }

        return Math.min(leftMin, rightMin) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
