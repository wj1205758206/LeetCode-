package codingoffer;

/**
 * BST中第 k 大的节点值
 */
public class KthNodeInBST_54 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        Solution solution = new KthNodeInBST_54().new Solution();
        System.out.println(solution.kthLargest(root, 1));
    }

    class Solution {
        int res = 0;
        int kth = 0;

        public int kthLargest(TreeNode root, int k) {
            if (root == null || k <= 0) return Integer.MIN_VALUE;

            dfs(root, k);

            return res;
        }

        private void dfs(TreeNode root, int k) {
            if (root == null) {
                return;
            }

            dfs(root.right, k);
            kth++;
            if (kth == k) {
                res = root.val;
                return;
            }
            dfs(root.left, k);
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
