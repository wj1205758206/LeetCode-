
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


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    public List<TreeNode> build(int low, int high) {
        List<TreeNode> result = new ArrayList<>();
        if (low > high) {
            result.add(null);
            return result;
        }

        for (int i = low; i <= high; i++) {
            List<TreeNode> leftTree = build(low, i - 1);
            List<TreeNode> rightTree = build(i + 1, high);
            for (TreeNode left : leftTree){
                for (TreeNode right : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
