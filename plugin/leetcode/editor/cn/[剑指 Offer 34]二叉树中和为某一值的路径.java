
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
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) return result;

        List<Integer> path = new ArrayList<>();

        traverse(root, 0, path, target);

        return result;
    }

    public void traverse(TreeNode root, int sum, List<Integer> path, int target) {
        path.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            result.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            traverse(root.left, sum, path, target);
        }
        if (root.right != null) {
            traverse(root.right, sum, path, target);
        }

        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
