package tree.easy;

/**
 * 判断是否是镜像二叉树
 */
public class SymmetricTree_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));

    }

    static class Solution {
        /**
         * 方法一：要想判断是否是镜像二叉树，可以翻转root根节点的左分支，再判断翻转后的左分支是否与root根节点的右分支相同
         * 之前翻转二叉树和判断两棵二叉树是否相同的函数都已经写过
         *
         * @param root 根节点
         * @return 返回是否是镜像二叉树
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            /*先翻转root左子树，再判断左子树与右子树是否相同*/
            return isSameTree(invertTree(root.left), root.right);
        }

        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val))
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        private TreeNode invertTree(TreeNode root) {
            if (root == null)
                return null;

            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;

            invertTree(root.left);
            invertTree(root.right);

            return root;
        }

        /**
         * 方法二：这个方法相当于省略了翻转函数和判断相同的函数
         * 通过扩展参数列表来增加约束条件，
         * 这个约束条件就是root根节点的左右子树满足以下条件：
         * - 左子树的左孩子等于右子树的右孩子
         * - 左子树的右孩子等于右子树的左孩子
         *
         * @param root
         * @return
         */
        public boolean isSymmetric3(TreeNode root) {
            return isSymmetric4(root.left, root.right);
        }

        private boolean isSymmetric4(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if ((p != null && q == null) || (p == null && q != null) || (q.val != p.val))
                return false;
            return isSymmetric4(p.left, q.right) && isSymmetric4(p.right, q.left);
        }

        /*
         * 想通过中序遍历看是否是回文子串，来判断是否是镜像二叉树，
         * 这种方法是不正确的，或者说只对一部分例子合适
         * 中序遍历不能够保证二叉树的结构是唯一的，也就是说不同结构的二叉树能够中序遍历结果是一样的
         * */
        /*String s = new String();

        public boolean isSymmetric2(TreeNode root) {
            inorder(root);
            return isPalindromic(s);
        }

        public boolean isPalindromic(String s) {
            String reverse = new StringBuffer(s).reverse().toString();
            if (s.equals(reverse))
                return true;
            return false;
        }

        private void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            s += root.val;
            inorder(root.right);
        }*/


    }
}
