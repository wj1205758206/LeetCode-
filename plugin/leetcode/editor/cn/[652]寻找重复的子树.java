
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
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return result;

        dfs(root);

        return result;
    }

    public String dfs(TreeNode root) {
        if (root == null){
            return "";
        }

        String left = dfs(root.left);
        String right = dfs(root.right);

        String sub = left + "," + right + "," + root.val;
        int count = map.getOrDefault(sub, 0);
        if (count == 1){
            result.add(root);
        }
        map.put(sub, count + 1);

        return sub;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
