
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
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        //深度优先遍历二叉树
        dfs(root, targetSum);
        return result;
    }

    public void dfs(TreeNode root, int targetSum) {
        //相当于先序遍历，进行一些相应的判断
        path.add(root.val); //记录路径
        targetSum -= root.val;
        //遍历到了叶子节点，看看是否满足目标值，满足则说明这条path符合条件
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        //深度继续遍历左右子树，先尝试走左子树，再尝试走右子树
        if (root.left != null) {
            dfs(root.left, targetSum);
        }
        if (root.right != null) {
            dfs(root.right, targetSum);
        }

        //走到这，说明到了左右子节点都为null,既叶子结点
        //需要回退到上一节点，尝试另一条子树
        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
