
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
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return sum;

        dfs(root, low, high);

        return sum;
    }

    public void dfs(TreeNode root, int low, int high) {
        if (root == null) return;

        if (root.val < low) {
            dfs(root.right, low, high);
        } else if (root.val > high) {
            dfs(root.left, low, high);
        } else {
            sum += root.val;

            dfs(root.left, low, high);
            dfs(root.right, low, high);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
