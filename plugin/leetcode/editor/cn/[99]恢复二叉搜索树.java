
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
    TreeNode first = null, ssecond = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int t = first.val;
        first.val = ssecond.val;
        ssecond.val = t;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);

        if (root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            ssecond = root;
        }
        pre = root;

        inorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
