
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
    public boolean isValidBST(TreeNode root) {
        return isVaild(root, null, null);
    }

    public boolean isVaild(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) return true;

        /*若 root.val 不符合 max 和 min 的限制，说明不是合法 BST*/
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }

        /*限定左子树的最大值是 root.val，右子树的最小值是 root.val，递归判断子树的合法性*/
        return isVaild(root.left, min, root) && isVaild(root.right, root, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
