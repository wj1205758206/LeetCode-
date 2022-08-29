
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
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        oneSizeMax(root);
        return res;
    }

    public int oneSizeMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = Math.max(0, oneSizeMax(root.left));
        int rightMaxSum = Math.max(0, oneSizeMax(root.right));
        int pathSum = leftMaxSum + rightMaxSum + root.val;
        res = Math.max(res, pathSum);
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
