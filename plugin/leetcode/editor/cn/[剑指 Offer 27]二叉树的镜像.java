
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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        swapLeftRight(root);

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }

    public void swapLeftRight(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
