package tree.medium;

/**
 * 二叉树剪枝
 */
public class BinaryTreePruning_814 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        Solution solution = new BinaryTreePruning_814().new Solution();
        TreeNode newRoot = solution.pruneTree(root);
        System.out.println(newRoot.right.right.val);
    }

    class Solution {
        /**
         * 方法一：DFS深度优先搜索，先序遍历
         *
         * @param root
         * @return
         */
        public TreeNode pruneTree(TreeNode root) {
            if (root == null)
                return null;
            /*如果当前root根节点的所有子节点加起来等于0，说明子节点中没有1，则直接返回null，代表可删除当前子树*/
            if (pruneHelper(root) == 0)
                return null;

            /*当前节点的左/右子树是剪枝后的左/右子树*/
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
            return root;
        }

        private int pruneHelper(TreeNode root) {
            if (root == null)
                return 0;
            return root.val + pruneHelper(root.left) + pruneHelper(root.right);
        }

        /**
         * 方法二：DFS深度优先搜索，后序遍历
         *
         * @param root
         * @return
         */
        public TreeNode pruneTree2(TreeNode root) {
            if (root == null)
                return null;

            /*当前节点的左/右子树是剪枝后的左/右子树*/
            root.left = pruneTree2(root.left);
            root.right = pruneTree2(root.right);

            /*后序遍历
             * 从底向上进行挨个删除操作*/
            if (root.left == null && root.right == null && root.val == 0)
                return null;

            return root;
        }
    }
}
