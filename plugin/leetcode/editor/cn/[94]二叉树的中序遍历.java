
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;

        dfs(root);

        return result;
    }

    public void dfs(TreeNode root) {

        if (root.left != null) {
            dfs(root.left);
        }


        result.add(root.val);

        if (root.right != null) {
            dfs(root.right);
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
