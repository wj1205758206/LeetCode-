package codingoffer;

/**
 * 判断平衡二叉树
 */
public class BalanceBinaryTree_55 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);

        Solution solution = new BalanceBinaryTree_55().new Solution();
        System.out.println(solution.isBalanced(root));
    }

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }


        private int getDepth(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(getDepth(root.left), getDepth(root.right));
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
