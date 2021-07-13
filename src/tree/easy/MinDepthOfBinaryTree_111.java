package tree.easy;

/**
 * 计算二叉树最小深度
 */
public class MinDepthOfBinaryTree_111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }

    static class Solution {
        /**
         * 计算二叉树最小深度，即根节点root到最近叶子结点的距离
         *
         * @param root 二叉树根节点
         * @return 返回最小深度
         */
        public int minDepth(TreeNode root) {
            /*基准条件*/
            if (root == null)
                return 0;
            /*如果根节点root的左子树为空，则计算右子树最小深度，再加一*/
            if (root.left == null) {
                return minDepth(root.right) + 1;
            }
            /*如果根节点root的右子树为空，则计算左子树最小深度，再加一*/
            if (root.right == null) {
                return minDepth(root.left) + 1;
            }

            /*如果左右子树都存在，则计算左右子树的最小值，再加一*/
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

        }

    }
}
