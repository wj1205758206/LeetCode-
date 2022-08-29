
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
    public String tree2str(TreeNode root) {
        return dfs(root);
    }

    public String dfs(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) {
            return root.val + "";
        }

        String leftStr = dfs(root.left);
        String rightStr = dfs(root.right);

        if (root.left != null && root.right == null) {
            return root.val + "(" + leftStr + ")";
        }
        if (root.left == null && root.right != null) {
            return root.val + "()" + "(" + rightStr + ")";
        }
        return root.val + "(" + leftStr + ")" + "(" + rightStr + ")";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
