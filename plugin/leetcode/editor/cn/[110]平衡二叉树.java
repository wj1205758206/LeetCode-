
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        //isBalanced函数的定义就是用来求是否是平衡二叉树的，那么返回的结果true或者false
        //平衡二叉树，必须保证左右子树高度差<=1 && 左子树是平衡二叉树 && 右子树也必须是
        return Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // getMaxDepth定义的返回结果是根节点开始的最大深度
        // 利用定义可求出left、right的最大深度
        int leftMax = getMaxDepth(root.left);
        int rightMax = getMaxDepth(root.right);
        // +1 就是root开始的最大深度
        return 1 + Math.max(leftMax, rightMax);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
