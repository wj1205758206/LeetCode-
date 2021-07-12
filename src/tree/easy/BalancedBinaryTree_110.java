package tree.easy;

/**
 * 判断是否是平衡二叉树
 */
public class BalancedBinaryTree_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));

    }

    static class Solution {
        /**
         * 平衡二叉树，左右子树的高度差的绝度值不能大于1
         * 使用递归定义判断左右子树是否是平衡二叉树
         *
         * @param root 根节点
         * @return 返回是否是平衡二叉树
         */
        public boolean isBalanced(TreeNode root) {
            /*基准条件*/
            if (root == null)
                return true;

            /*左右子树高度差绝对值不能大于1*/
            if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
                return false;

            /*递归定义判断左右子树的是否也是平衡二叉树*/
            return isBalanced(root.left) && isBalanced(root.right);
        }

        private int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
