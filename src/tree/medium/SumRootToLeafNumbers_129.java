package tree.medium;

/**
 * 求根节点到叶节点数字之和
 */
public class SumRootToLeafNumbers_129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution solution = new SumRootToLeafNumbers_129().new Solution();
        int sum = solution.sumNumbers(root);
        System.out.println(sum);

    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索
         *
         * @param root
         * @return
         */
        public int sumNumbers(TreeNode root) {
            /*构造辅助函数DFS，扩展参数列表，传入sum计算累加和，进行递归遍历*/
            return DFS(root, 0);
        }

        private int DFS(TreeNode root, int sum) {
            if (root == null)
                return 0;

            /*递归遍历的同时计算每个节点的累加和，每次左移一位乘以10，再加上个位数，即当前节点的值*/
            sum = sum * 10 + root.val;

            /*到达叶子节点就返回这条路径的累加和*/
            if (root.left == null && root.right == null)
                return sum;

            /*递归累加左右子树中所有到叶子节点路径的累加和值*/
            return DFS(root.left, sum) + DFS(root.right, sum);
        }
    }
}
