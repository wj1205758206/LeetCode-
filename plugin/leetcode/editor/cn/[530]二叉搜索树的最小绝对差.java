
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
    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;



        dfs(root);

        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;

        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
