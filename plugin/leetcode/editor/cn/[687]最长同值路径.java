
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
    int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return maxLen;
        traverse(root, root.val);
        return maxLen;
    }

    public int traverse(TreeNode root, int parentVal) {
        if (root == null) return 0;
        int leftLen = traverse(root.left, root.val);
        int rightLen = traverse(root.right, root.val);

        maxLen = Math.max(maxLen, leftLen + rightLen);
        if (root.val != parentVal) {
            return 0;
        }

        return 1 + Math.max(leftLen, rightLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
