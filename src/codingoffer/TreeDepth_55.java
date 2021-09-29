package codingoffer;

/**
 * 计算树的最大深度
 */
public class TreeDepth_55 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return dfs(root);
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(dfs(root.left), dfs(root.right));
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
