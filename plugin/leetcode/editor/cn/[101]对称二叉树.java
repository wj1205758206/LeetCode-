
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        //判断root节点的左右子树是否对称
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            //left和right都为null 返回true，对称
            //二者有一个不为null,则不对称，返回false
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        //递归判断左右子节点是否对称相同
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
