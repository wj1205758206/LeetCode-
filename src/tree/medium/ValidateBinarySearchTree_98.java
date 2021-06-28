package tree.medium;

/**
 * 判断BST的合法性
 */
public class ValidateBinarySearchTree_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);

        Solution solution = new Solution();
        boolean validBST = solution.isValidBST(root);
        System.out.println(validBST);

    }

    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        /**
         * 需要注意的是，这里对于每一个节点root来说不仅要满足左孩子的值小于父节点，右孩子的值大于父节点，
         * 还要满足root的整个左子树都要小于root的值，整个右子树都要大于root的值
         *
         * 可以借助辅助函数，增加函数参数列表，在参数中携带额外信息，将上述的约束传递给子树的所有节点，在这里扩展参数列表起到了递归约束作用
         * 限定以root为根节点的子树节点必须满足 max.val > root.val > min.val
         * @param root  每次递归时的根节点root
         * @param min   整个子树的最小节点
         * @param max   整个子树的最大节点
         * @return      返回二叉搜索树是否合法
         */
        private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            /*基准条件*/
            if (root == null)
                return true;

            /*若 root.val 不符合 max 和 min 的限制，说明不是合法 BST*/
            if (min != null && root.val <= min.val)
                return false;
            if (max != null && root.val >= max.val)
                return false;

            /*限定左子树的最大值是 root.val，右子树的最小值是 root.val，递归判断子树的合法性*/
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }
}
