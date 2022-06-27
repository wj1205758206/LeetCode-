
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
    public int sumNumbers(TreeNode root) {
        /*构造辅助函数DFS，扩展参数列表，传入sum计算累加和，进行递归遍历*/
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        /*递归遍历的同时计算每个节点的累加和，每次左移一位乘以10，再加上个位数，即当前节点的值*/
        sum = sum * 10 + root.val;
        /*到达叶子节点就返回这条路径的累加和*/
        if (root.left == null && root.right == null) {
            return sum;
        }
        /*递归累加左右子树中所有到叶子节点路径的累加和值*/
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
