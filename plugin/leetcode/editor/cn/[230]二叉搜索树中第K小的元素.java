
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int kth = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);

        return res;
    }

    public void dfs(TreeNode root, int k){
        if (root == null) return;

        dfs(root.left, k);

        kth++;
        if (k == kth){
            res = root.val;
            return;
        }

        dfs(root.right, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
