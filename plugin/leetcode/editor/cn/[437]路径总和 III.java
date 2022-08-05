
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
    HashMap<Long, Integer> preSumCount = new HashMap <>();
    long pathSum;
    int targetSum;
    int result = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        this.pathSum = 0;
        this.targetSum = targetSum;
        this.preSumCount.put(0L, 1);

        traverse(root);

        return result;
    }

    public void traverse(TreeNode root) {
        if (root == null) return;

        pathSum += root.val;
        result += preSumCount.getOrDefault(pathSum - targetSum, 0);
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left);
        traverse(root.right);

        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) - 1);
        pathSum -= root.val;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
