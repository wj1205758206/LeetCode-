
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int result = Integer.MIN_VALUE;
    int kth = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) return Integer.MIN_VALUE;

        dfs(root, k);
        return result;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;

        //因为是找第k个最大的，所以先右后左
        dfs(root.right, k);

        //BST中序遍历是排序的顺序
        kth++;
        if (k == kth) {
            result = root.val;
            return;
        }

        dfs(root.left, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
