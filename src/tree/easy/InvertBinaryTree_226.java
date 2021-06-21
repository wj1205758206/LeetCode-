package tree.easy;

/**
 * 左右翻转整棵二叉树的节点
 */
public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        TreeNode invertTree = solution.invertTree2(root);
        System.out.println(invertTree.left.left.val);

    }

    static class Solution {
        /**
         * 方法一：先序遍历，整棵树自上往下的翻转
         * @param root  传入翻转树的根节点
         * @return  返回翻转后的根节点
         */
        public TreeNode invertTree(TreeNode root) {
            /*基准条件
            * 如果当前节点为null，无需翻转直接返回null*/
            if (root == null)
                return null;

            /*先序遍历，翻转当前root节点的左右孩子节点，整棵树自上往下的翻转*/
            TreeNode treeNode = new TreeNode();
            treeNode = root.right;
            root.right = root.left;
            root.left = treeNode;

            /*以当前节点的左孩子作为root节点，继续向下翻转*/
            invertTree(root.left);

            /*以当前节点的右孩子作为root节点，继续向下翻转*/
            invertTree(root.right);

            /*返回是自下往上的返回，最后返回的就是最上层的根节点*/
            return root;
        }

        /**
         * 方法二：后序遍历，整棵树自下往上的翻转
         * @param root  传入翻转树的根节点
         * @return  返回翻转后的根节点
         */
        public TreeNode invertTree2(TreeNode root) {
            /*基准条件
             * 如果当前节点为null，无需翻转直接返回null*/
            if (root == null)
                return null;

            /*先翻转当前root节点的左孩子节点，把当前节点的左孩子当做下一层的root进行翻转，整个数自下往上的翻转*/
            invertTree(root.left);

            /*先翻转当前root节点的右孩子节点，把当前节点的右孩子当做下一层的root进行翻转，整个数自下往上的翻转*/
            invertTree(root.right);

            /*后序遍历，翻转当前root节点的左右孩子节点，整棵树自下往上的翻转*/
            TreeNode treeNode = new TreeNode();
            treeNode = root.right;
            root.right = root.left;
            root.left = treeNode;

            /*返回是自下往上的返回，最后返回的就是最上层的根节点*/
            return root;
        }
    }
}
