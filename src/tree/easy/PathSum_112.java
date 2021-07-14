package tree.easy;

/**
 * 计算二叉树路径和
 */
public class PathSum_112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        Solution solution = new PathSum_112().new Solution();
        System.out.println(solution.hasPathSum(root, 3));
    }

    class Solution {
        /**
         * 判断从root-leaf是否存在一条路径，使得路径上的节点值之和等于目标值
         *
         * @param root      根节点
         * @param targetSum 目标值
         * @return 返回是否存在该路径
         */
        public boolean hasPathSum(TreeNode root, int targetSum) {
            /*基准条件*/
            if (root == null)
                return false;

            /*判断是否遍历到了叶子节点，并判断是否目标值不断减小，已经减小到等于叶子节点的值*/
            if (root.left == null && root.right == null && targetSum == root.val)
                return true;

            /*要想判断是否存在从root根节点到叶子节点路劲上所有节点值之和等于目标值，
             * 可以先判断是否存在root的左子树或者右子树到叶子结点路径上的所有节点值之和等于目标值减去当前root的值*/
            return (hasPathSum(root.left, targetSum - root.val)) ||
                    (hasPathSum(root.right, targetSum - root.val));
        }
    }
}
