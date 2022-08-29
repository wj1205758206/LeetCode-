
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
    public int countNodes(TreeNode root) {
        TreeNode left, right;
        int lc = 0, rc = 0;
        left = right = root;
        while (left != null) {
            left = left.left;
            lc++;
        }
        while (right != null) {
            right = right.right;
            rc++;
        }

        if (lc == rc) {
            return (int) Math.pow(2, lc) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
