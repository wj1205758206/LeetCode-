package tree.easy;

/**
 * 判断一棵树是否是另一棵树的子树
 */
public class SubtreeOfAnotherTree_572 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        Solution solution = new SubtreeOfAnotherTree_572().new Solution();
        System.out.println(solution.isSubtree(root, subRoot));

    }

    class Solution {
        /*两棵树都为null是返回true
         * 只有其中一棵树为null时，返回false
         * 如果比较的两棵树是相同的，则返回true
         * 使用递归定义，从root根节点的左子树或者右子树中找是否存在与subRoot相同的子树*/
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null)
                return true;
            if (root == null)
                return false;
            if (isSame(root, subRoot))
                return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        /*判断传入的两棵树是否是完全相同的两棵树*/
        private boolean isSame(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null)
                return true;
            if (root == null || subRoot == null)
                return false;
            return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        }

    }
}
