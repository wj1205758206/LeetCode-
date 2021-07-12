package tree.easy;

/**
 * 计算二叉树最大深度
 */
public class MaxDepthOfBinaryTree_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));

    }

    static class Solution {

        /**
         * 要想计算二叉树的最大深度，就需要计算出当前root根节点左右子树的最大深度分别是多少，然后取最大值
         * 使用递归定义，递归计算出左右子树的最大深度，root节点最大深度就是左右子树最大深度+1，这个1就是root本身也要算一层深度
         *
         * @param root 根节点
         * @return 返回二叉树的最大深度
         */
        public int maxDepth(TreeNode root) {
            /*基准条件*/
            if (root == null)
                return 0;

            /*递归计算左右子树的最大深度，然后取其最大值，加1，就是二叉树最大深度*/
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
