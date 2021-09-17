package codingoffer;

/**
 * 镜像二叉树
 */
public class MirrorOfBinaryTree_27 {
    public static void main(String[] args) {

    }

    class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;

            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;

            if (root.left != null)
                mirrorTree(root.left);
            if (root.right != null)
                mirrorTree(root.right);

            return root;
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
