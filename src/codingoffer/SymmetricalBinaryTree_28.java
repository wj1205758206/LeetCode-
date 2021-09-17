package codingoffer;

/**
 * 判断对称二叉树
 */
public class SymmetricalBinaryTree_28 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null)
                return true;
            return isSame(inverseTree(root.left), root.right);
        }

        private boolean isSame(TreeNode r1, TreeNode r2) {
            if (r1 == null && r2 == null)
                return true;
            if (r1 != null || r2 != null)
                return false;

            return r1.val == r2.val && isSame(r1.left, r2.left) && isSame(r1.right, r2.right);
        }

        private TreeNode inverseTree(TreeNode root) {
            if (root == null)
                return null;

            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;

            if (root.left != null)
                inverseTree(root.left);
            if (root.right != null)
                inverseTree(root.right);

            return root;
        }

        public boolean isSymmetric2(TreeNode root) {
            if (root == null)
                return false;

            return isLeftRight(root.left, root.right);
        }

        private boolean isLeftRight(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null)
                return false;
            /*对称二叉树的特性，root-left-right和root-right-left的序列是一样的
             * 所以我们改造一下前序遍历，让它先遍历右孩子
             * 然后使用辅助函数，扩展参数列表
             * 即判断一个root的左子树的左孩子是否等于右子树的右孩子 并且 左子树的右孩子是否等于右子树的左孩子*/
            return p.val == q.val && isLeftRight(p.right, q.left) && isLeftRight(p.left, q.right);
        }


    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
