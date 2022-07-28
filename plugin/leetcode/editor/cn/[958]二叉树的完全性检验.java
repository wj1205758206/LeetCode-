
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
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false; //遍历完所有非空节点时变成true
        while (!queue.isEmpty()) {
            int curLevelSize = queue.size();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    // 第一次遇到 null 时 end 变成 true
                    // 如果之后的所有节点都是 null，则说明是完全二叉树
                    end = true;
                } else {
                    if (end) {
                        //end已经变为true了，但是又遇到了非空节点，这说明不是完全二叉树
                        return false;
                    }
                    //无需判断是否null，需要把null节点也放进去
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
