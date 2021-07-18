package tree.easy;

/**
 * 计算二叉树所有左叶子节点之和
 */
public class SumOfLeftLeaves_404 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new SumOfLeftLeaves_404().new Solution();
        int sum = solution.sumOfLeftLeaves(root);
        System.out.println(sum);
    }

    class Solution {
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            /*基准条件*/
            if (root == null)
                return 0;
            /*需要判断哪些是左叶子
            * 当前根节点root有左孩子，并且这个左孩子是叶子节点，那么就累加sum*/
            if ((root.left != null) && (root.left.left == null && root.left.right == null)) {
                sum += root.left.val;
            }
            /*使用递归定义，从左子树和右子树中查找左叶子节点*/
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);

            /*返回所有左叶子节点值的和*/
            return sum;
        }
    }
}
