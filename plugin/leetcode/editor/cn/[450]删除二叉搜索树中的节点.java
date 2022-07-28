
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        //前序遍历代码
        if (root.val == key) {
            //左子树为空的情况
            if (root.left == null) return root.right;
            //右子树为空的情况
            if (root.right == null) return root.left;

            //左右子树都不为null的情况，需要将右子树的最左节点替代要删除的节点
            TreeNode minNode = getMin(root.right);
            //找到以后，利用函数定义，删除这个minNode
            root.right = deleteNode(root.right, minNode.val);
            //minNode替换原来的节点，并连接上左右子树
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    public TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
