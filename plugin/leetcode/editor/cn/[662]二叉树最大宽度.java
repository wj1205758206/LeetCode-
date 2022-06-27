
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int maxWidth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        //直接更改节点值为编号值
        root.val = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            //记录最大宽度：当我们在看同一层深度的位置值 L 和 R 的时候，宽度就是 R - L + 1
            maxWidth = Math.max(maxWidth,
                    queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    //左子节点编号: root.val * 2 - 1
                    node.left.val = node.val * 2 - 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    //右子节点编号: root.val * 2
                    node.right.val = node.val * 2;
                    queue.add(node.right);
                }
            }
        }
        return maxWidth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
