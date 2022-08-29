
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
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;

        dfs(root);

        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            path.add(root.val + "");

            result.add(String.join("->", path));

            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val + "");

        dfs(root.left);
        dfs(root.right);

        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
