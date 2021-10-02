package codingoffer;

/**
 * 二叉树的最近公共祖先
 */
public class CommonParentInTree_II_68 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        Solution solution = new CommonParentInTree_II_68().new Solution();
        System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val == root.val || q.val == root.val) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) return root;
            if (left == null) return right;
            if (right == null) return left;

            return null;
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
