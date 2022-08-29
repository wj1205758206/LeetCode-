
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

    int res = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        dfs(root,  root.val);

        return res;
    }

    public void dfs(TreeNode root, int cur) {
        if (root == null) return;

        if (cur !=  root.val) {
            if (res == -1){
                res = root.val;
            }else {
                res = Math.min(res, root.val);
            }
            return;
        }

        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
